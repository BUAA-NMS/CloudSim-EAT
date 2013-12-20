/*
 * Title:        CloudSim Toolkit
 * Description:  CloudSim (Cloud Simulation) Toolkit for Modeling and Simulation of Clouds
 * Licence:      GPL - http://www.gnu.org/copyleft/gpl.html
 *
 * Copyright (c) 2009-2012, The University of Melbourne, Australia
 */

package org.cloudbus.cloudsim;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.cloudbus.cloudsim.core.CloudSim;
import org.cloudbus.cloudsim.lists.PeList;
import org.cloudbus.cloudsim.provisioners.BwProvisioner;
import org.cloudbus.cloudsim.provisioners.RamProvisioner;

/**
 * The class of a host supporting dynamic workloads and performance degradation.
 * 
 * @author Anton Beloglazov
 * @since CloudSim Toolkit 2.0
 */
public class HostDynamicWorkload extends Host {

	/** The utilization mips. */
	private double utilizationMips;

	/** The previous utilization mips. */
	private double previousUtilizationMips;
	
	/** The utilization Ram. */
	private int utilizationRam;

	/** The previous utilization Ram. */
	private int previousUtilizationRam;
	
	/** The state history. */
	private final List<HostStateHistoryEntry> stateHistory = new LinkedList<HostStateHistoryEntry>();

	/**
	 * Instantiates a new host.
	 * 
	 * @param id the id
	 * @param ramProvisioner the ram provisioner
	 * @param bwProvisioner the bw provisioner
	 * @param storage the storage
	 * @param peList the pe list
	 * @param vmScheduler the VM scheduler
	 */
	public HostDynamicWorkload(
			int id,
			RamProvisioner ramProvisioner,
			BwProvisioner bwProvisioner,
			long storage,
			List<? extends Pe> peList,
			VmScheduler vmScheduler) {
		super(id, ramProvisioner, bwProvisioner, storage, peList, vmScheduler);
		setUtilizationMips(0);
		setPreviousUtilizationMips(0);
		setUtilizationRam(0);
		setPreviousUtilizationRam(0);
	}

	/* 
	 * (non-Javadoc)
	 * @see cloudsim.Host#updateVmsProcessing(double)
	 */
	@Override
	public double updateVmsProcessing(double currentTime) {
		double smallerTime = super.updateVmsProcessing(currentTime);
		setPreviousUtilizationMips(getUtilizationMips());
		setUtilizationMips(0);
		setPreviousUtilizationRam(getUtilizationRam());
		setUtilizationRam(0);
		double hostTotalRequestedMips = 0;
		int hostTotalRequestedRam = 0;
		
		for (Vm vm : getVmList()) {
			// 释放指定的vm
			getVmScheduler().deallocatePesForVm(vm);
			getRamProvisioner().deallocateRamForVm(vm);
		}

		for (Vm vm : getVmList()) {
			//为指定的vm分配资源
			getVmScheduler().allocatePesForVm(vm, vm.getCurrentRequestedMips());
			getRamProvisioner().allocateRamForVm(vm, vm.getCurrentRequestedRam());
		}

		for (Vm vm : getVmList()) {
			double totalRequestedMips = vm.getCurrentRequestedTotalMips();
			double totalAllocatedMips = getVmScheduler().getTotalAllocatedMipsForVm(vm);
			int totalRequestedRam = vm.getCurrentRequestedRam();
			int totalAllocatedRam = getRamProvisioner().getAllocatedRamForVm(vm);

			if (!Log.isDisabled()) {
				// 打印Mips的情况
				Log.formatLine(
						"%.2f: [Host #" + getId() + "] Total allocated MIPS for VM #" + vm.getId()
								+ " (Host #" + vm.getHost().getId()
								+ ") is %.2f, was requested %.2f out of total %.2f (%.2f%%)",
						CloudSim.clock(),
						totalAllocatedMips,
						totalRequestedMips,
						vm.getMips(),
						totalRequestedMips / vm.getMips() * 100);

				// 打印Ram的情况
				Log.formatLine(
						"%.2f: [Host #" + getId() + "] Total allocated Ram for VM #" + vm.getId()
								+ " (Host #" + vm.getHost().getId()
								+ ") is %d, was requested %d out of total %d (%.2f%%)",
						CloudSim.clock(),
						totalAllocatedRam,
						totalRequestedRam,
						vm.getRam(),
						totalRequestedRam*1.0 / vm.getRam() * 100);
				
				// 打印PE的分配情况
				List<Pe> pes = getVmScheduler().getPesAllocatedForVM(vm);
				StringBuilder pesString = new StringBuilder();
				for (Pe pe : pes) {
					pesString.append(String.format(" PE #" + pe.getId() + ": %.2f.", pe.getPeProvisioner()
							.getTotalAllocatedMipsForVm(vm)));
				}
				Log.formatLine(
						"%.2f: [Host #" + getId() + "] MIPS for VM #" + vm.getId() + " by PEs ("
								+ getNumberOfPes() + " * " + getVmScheduler().getPeCapacity() + ")."
								+ pesString,
						CloudSim.clock());
			}

			if (getVmsMigratingIn().contains(vm)) {
				Log.formatLine("%.2f: [Host #" + getId() + "] VM #" + vm.getId()
						+ " is being migrated to Host #" + getId(), CloudSim.clock());
			} else {
				//没有分配够
				if (totalAllocatedMips + 0.1 < totalRequestedMips) {
					Log.formatLine("%.2f: [Host #" + getId() + "] Under allocated MIPS for VM #" + vm.getId()
							+ ": %.2f", CloudSim.clock(), totalRequestedMips - totalAllocatedMips);
				}

				vm.addStateHistoryEntry(
						currentTime,
						totalAllocatedMips,
						totalRequestedMips,
						totalAllocatedRam,
						totalRequestedRam,
						(vm.isInMigration() && !getVmsMigratingIn().contains(vm)));

				if (vm.isInMigration()) {
					Log.formatLine(
							"%.2f: [Host #" + getId() + "] VM #" + vm.getId() + " is in migration",
							CloudSim.clock());
					totalAllocatedMips /= 0.9; // performance degradation due to migration - 10%
				}
			}

			setUtilizationMips(getUtilizationMips() + totalAllocatedMips);
			hostTotalRequestedMips += totalRequestedMips;
			setUtilizationRam(getUtilizationRam() + totalAllocatedRam);
			hostTotalRequestedRam += totalRequestedRam;
		}

		addStateHistoryEntry(
				currentTime,
				getUtilizationMips(),
				hostTotalRequestedMips,
				getUtilizationRam(),
				hostTotalRequestedRam,
				(getUtilizationMips() > 0)||(getUtilizationRam()>0));

		return smallerTime;
	}

	/**
	 * Gets the completed vms.
	 * 返回已经完成的VM
	 * 
	 * @return the completed vms
	 */
	public List<Vm> getCompletedVms() {
		List<Vm> vmsToRemove = new ArrayList<Vm>();
		for (Vm vm : getVmList()) {
			if (vm.isInMigration()) {
				continue;
			}
			if (vm.getCurrentRequestedTotalMips() == 0) {
				vmsToRemove.add(vm);
			}
		}
		return vmsToRemove;
	}

	/**
	 * Gets the max utilization among by all PEs.
	 * 
	 * @return the utilization
	 */
	public double getMaxUtilization() {
		return PeList.getMaxUtilization(getPeList());
	}

	/**
	 * Gets the max utilization among by all PEs allocated to the VM.
	 * 
	 * @param vm the vm
	 * @return the utilization
	 */
	public double getMaxUtilizationAmongVmsPes(Vm vm) {
		return PeList.getMaxUtilizationAmongVmsPes(getPeList(), vm);
	}

	/**
	 * Gets the utilization of memory in bytes.
	 * 内存byte
	 * 
	 * @return the utilization of memory
	 */
	public double getUtilizationOfRam() {
		return getRamProvisioner().getUsedRam();
	}

	/**
	 * Gets the utilization of bw in bytes.
	 * 网络byte
	 * 
	 * @return the utilization of bw
	 */
	public double getUtilizationOfBw() {
		return getBwProvisioner().getUsedBw();
	}

	/**
	 * Get current utilization of CPU in MIPS.
	 * 
	 * @return current utilization of CPU in MIPS
	 */
	public double getUtilizationOfCpuMips() {
		return getUtilizationMips();
	}
	
    //以下为CPU使用情况	
	/**
	 * Get current utilization of CPU in percentage.
	 * 返回现CPU百分比
	 * 
	 * @return current utilization of CPU in percents
	 */
	public double getUtilizationOfCpu() {
		double utilization = getUtilizationMips() / getTotalMips();
		if (utilization > 1 && utilization < 1.01) {
			utilization = 1;
		}
		return utilization;
	}

	/**
	 * Gets the previous utilization of CPU in percentage.
	 * 返回前CPU百分比
	 * 
	 * @return the previous utilization of cpu
	 */
	public double getPreviousUtilizationOfCpu() {
		double utilization = getPreviousUtilizationMips() / getTotalMips();
		if (utilization > 1 && utilization < 1.01) {
			utilization = 1;
		}
		return utilization;
	}
	
	/**
	 * Gets the utilization mips.
	 * 
	 * @return the utilization mips
	 */
	public double getUtilizationMips() {
		return utilizationMips;
	}

	/**
	 * Sets the utilization mips.
	 * 
	 * @param utilizationMips the new utilization mips
	 */
	protected void setUtilizationMips(double utilizationMips) {
		this.utilizationMips = utilizationMips;
	}

	/**
	 * Gets the previous utilization mips.
	 * 
	 * @return the previous utilization mips
	 */
	public double getPreviousUtilizationMips() {
		return previousUtilizationMips;
	}

	/**
	 * Sets the previous utilization mips.
	 * 
	 * @param previousUtilizationMips the new previous utilization mips
	 */
	protected void setPreviousUtilizationMips(double previousUtilizationMips) {
		this.previousUtilizationMips = previousUtilizationMips;
	}	
	
	//以下为MEM使用情况
	/**
	 * Get current utilization of memory in percentage.
	 * 内存百分比
	 * 
	 * @return current utilization of memory in percents
	 */	
	public double getUtilizationOfMem() {
		double utilization = (double)getUtilizationRam() / (double)getRam();
		if (utilization > 1 && utilization < 1.01) {
			utilization = 1;
		}
		return utilization;
	}
	
	/**
	 * Gets the previous utilization of memory in percentage.
	 * 内存百分比
	 * 
	 * @return the previous utilization of memory
	 */
	public double getPreviousUtilizationOfMem() {
		double utilization = (double)getPreviousUtilizationRam()  /(double) getRam();
		if (utilization > 1 && utilization < 1.01) {
			utilization = 1;
		}
		return utilization;
	}

	/**
	 * Gets the utilization of memroy in bytes.
	 * 
	 * @return the utilization Ram
	 */
	public int getUtilizationRam() {
		return utilizationRam;
	}

	/**
	 * Sets the utilization of memroy in bytes.
	 * 
	 * @param utilizationRam the new utilization of memroy in bytes
	 */	
	protected void setUtilizationRam(int utilizationRam) {
		// TODO Auto-generated method stub	
		this.utilizationRam = utilizationRam;
	}
	
	/**
	 * Gets the previous utilization of memroy in bytes.
	 * 
	 * @return the previous utilization Ram
	 */
	public int getPreviousUtilizationRam() {
		return previousUtilizationRam;
	}
	
	protected void setPreviousUtilizationRam(int previousUtilizationRam) {
		// TODO Auto-generated method stub
		this.previousUtilizationRam = previousUtilizationRam;
	}

	/**
	 * Gets the state history.
	 * 
	 * @return the state history
	 */
	public List<HostStateHistoryEntry> getStateHistory() {
		return stateHistory;
	}

	/**
	 * Adds the state history entry.
	 * 
	 * @param time the time
	 * @param allocatedMips the allocated mips
	 * @param requestedMips the requested mips
	 * @param isActive the is active
	 */
	public void addStateHistoryEntry(
			double time, 
			double allocatedMips, 
			double requestedMips, 
			double allocatedRam, 
			double requestedRam, 
			boolean isActive) {
//		HostStateHistoryEntry newState = new HostStateHistoryEntry(
//				time,
//				allocatedMips,
//				requestedMips,
//				isActive);
		HostStateHistoryEntry newState = new HostStateHistoryEntry(
				time,
				allocatedMips,
				requestedMips,
				allocatedRam,
				requestedRam,
				isActive);
		if (!getStateHistory().isEmpty()) {
			HostStateHistoryEntry previousState = getStateHistory().get(getStateHistory().size() - 1);
			if (previousState.getTime() == time) {
				getStateHistory().set(getStateHistory().size() - 1, newState);
				return;
			}
		}
		getStateHistory().add(newState);
	}

}
