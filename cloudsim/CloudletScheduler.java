/*
 * Title:        CloudSim Toolkit
 * Description:  CloudSim (Cloud Simulation) Toolkit for Modeling and Simulation of Clouds
 * Licence:      GPL - http://www.gnu.org/copyleft/gpl.html
 *
 * Copyright (c) 2009-2012, The University of Melbourne, Australia
 */

package org.cloudbus.cloudsim;

import java.util.List;

/**
 * CloudletScheduler is an abstract class that represents the policy of scheduling performed by a
 * virtual machine. So, classes extending this must execute Cloudlets. Also, the interface for
 * cloudlet management is also implemented in this class.
 * 由虚拟机执行的任务调度策略
 * 
 * @author Rodrigo N. Calheiros
 * @author Anton Beloglazov
 * @since CloudSim Toolkit 1.0
 */
public abstract class CloudletScheduler {

	/** The previous time. */
	private double previousTime;

	/** The current mips share. 分配给调度器的MPIS列表 */
	private List<Double> currentMipsShare;

	/**
	 * Creates a new CloudletScheduler object. This method must be invoked before starting the
	 * actual simulation.
	 * 
	 * 
	 * @pre $none
	 * @post $none
	 */
	public CloudletScheduler() {
		setPreviousTime(0.0);
	}

	/**
	 * Updates the processing of cloudlets running under management of this scheduler.
	 * 更新cloudlet的执行情况，返回值是最早完成的cloudlet的预计完成时间
	 * 
	 * @param currentTime current simulation time
	 * @param mipsShare array with MIPS share of each processor available to the scheduler
	 * @return time predicted completion time of the earliest finishing cloudlet, or 0 if there is no
	 *         next events
	 * @pre currentTime >= 0
	 * @post $none
	 */
	public abstract double updateVmProcessing(double currentTime, List<Double> mipsShare);

	/**
	 * Receives an cloudlet to be executed in the VM managed by this scheduler.
	 * 提交任务
	 * 
	 * @param gl the submited cloudlet
	 * @param fileTransferTime time required to move the required files from the SAN to the VM
	 * @return expected finish time of this cloudlet, or 0 if it is in a waiting queue
	 * @pre gl != null
	 * @post $none
	 */
	public abstract double cloudletSubmit(Cloudlet gl, double fileTransferTime);

	/**
	 * Receives an cloudlet to be executed in the VM managed by this scheduler.
	 * 
	 * @param gl the submited cloudlet
	 * @return expected finish time of this cloudlet, or 0 if it is in a waiting queue
	 * @pre gl != null
	 * @post $none
	 */
	public abstract double cloudletSubmit(Cloudlet gl);

	/**
	 * Cancels execution of a cloudlet.
	 * 取消cloudlet的执行
	 * 
	 * @param clId ID of the cloudlet being cancealed
	 * @return the canceled cloudlet, $null if not found
	 * @pre $none
	 * @post $none
	 */
	public abstract Cloudlet cloudletCancel(int clId);

	/**
	 * Pauses execution of a cloudlet.
	 * 暂停cloudlet的执行
	 * 
	 * @param clId ID of the cloudlet being paused
	 * @return $true if cloudlet paused, $false otherwise
	 * @pre $none
	 * @post $none
	 */
	public abstract boolean cloudletPause(int clId);

	/**
	 * Resumes execution of a paused cloudlet.
	 * 恢复cloudlet的执行
	 * 
	 * @param clId ID of the cloudlet being resumed
	 * @return expected finish time of the cloudlet, 0.0 if queued
	 * @pre $none
	 * @post $none
	 */
	public abstract double cloudletResume(int clId);

	/**
	 * Processes a finished cloudlet.
	 * 处理一个已结束的cloudlet
	 * 
	 * @param rcl finished cloudlet
	 * @pre rgl != $null
	 * @post $none
	 */
	public abstract void cloudletFinish(ResCloudlet rcl);

	/**
	 * Gets the status of a cloudlet.
	 * 返回cloudlet的状态，－1表示没有找到该任务
	 * 
	 * @param clId ID of the cloudlet
	 * @return status of the cloudlet, -1 if cloudlet not found
	 * @pre $none
	 * @post $none
	 */
	public abstract int getCloudletStatus(int clId);

	/**
	 * Informs about completion of some cloudlet in the VM managed by this scheduler.
	 * 监测是否有已经结束的任务
	 * 
	 * @return $true if there is at least one finished cloudlet; $false otherwise
	 * @pre $none
	 * @post $none
	 */
	public abstract boolean isFinishedCloudlets();

	/**
	 * Returns the next cloudlet in the finished list, $null if this list is empty.
	 * 返回结束列表中的下一个任务，列表为空则返回$null
	 * 
	 * @return a finished cloudlet
	 * @pre $none
	 * @post $none
	 */
	public abstract Cloudlet getNextFinishedCloudlet();

	/**
	 * Returns the number of cloudlets runnning in the virtual machine.
	 * 返回还在本虚拟机中运行的任务
	 * 
	 * @return number of cloudlets runnning
	 * @pre $none
	 * @post $none
	 */
	public abstract int runningCloudlets();

	/**
	 * Returns one cloudlet to migrate to another vm.
	 * 返回迁移到其他虚拟机的任务
	 * 
	 * @return one running cloudlet
	 * @pre $none
	 * @post $none
	 */
	public abstract Cloudlet migrateCloudlet();

	/**
	 * Get utilization created by all cloudlets.
	 * 返回所有任务导致的CPU使用率
	 * 
	 * @param time the time
	 * @return total utilization
	 */
	public abstract double getTotalUtilizationOfCpu(double time);

	/**
	 * Gets the current requested mips.
	 * 返回需求的MIPS
	 * 
	 * @return the current mips
	 */
	public abstract List<Double> getCurrentRequestedMips();

	/**
	 * Gets the total current mips for the Cloudlet.
	 * 获得制动
	 * 
	 * @param rcl the rcl
	 * @param mipsShare the mips share
	 * @return the total current mips
	 */
	public abstract double getTotalCurrentAvailableMipsForCloudlet(ResCloudlet rcl, List<Double> mipsShare);

	/**
	 * Gets the total current requested mips for cloudlet.
	 * 
	 * @param rcl the rcl
	 * @param time the time
	 * @return the total current requested mips for cloudlet
	 */
	public abstract double getTotalCurrentRequestedMipsForCloudlet(ResCloudlet rcl, double time);

	/**
	 * Gets the total current allocated mips for cloudlet.
	 * 
	 * @param rcl the rcl
	 * @param time the time
	 * @return the total current allocated mips for cloudlet
	 */
	public abstract double getTotalCurrentAllocatedMipsForCloudlet(ResCloudlet rcl, double time);

	/**
	 * Gets the current requested ram.
	 * 
	 * @return the current requested ram
	 */
	public abstract double getCurrentRequestedUtilizationOfMem();

	/**
	 * Gets the current requested bw.
	 * 
	 * @return the current requested bw
	 */
	public abstract double getCurrentRequestedUtilizationOfBw();

	/**
	 * Gets the previous time.
	 * 
	 * @return the previous time
	 */
	public double getPreviousTime() {
		return previousTime;
	}

	/**
	 * Sets the previous time.
	 * 
	 * @param previousTime the new previous time
	 */
	protected void setPreviousTime(double previousTime) {
		this.previousTime = previousTime;
	}

	/**
	 * Sets the current mips share.
	 * 
	 * @param currentMipsShare the new current mips share
	 */
	protected void setCurrentMipsShare(List<Double> currentMipsShare) {
		this.currentMipsShare = currentMipsShare;
	}

	/**
	 * Gets the current mips share.
	 * 
	 * @return the current mips share
	 */
	public List<Double> getCurrentMipsShare() {
		return currentMipsShare;
	}

}
