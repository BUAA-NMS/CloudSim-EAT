package org.cloudbus.cloudsim.examples.power;

import org.cloudbus.cloudsim.power.models.PowerModel;
import org.cloudbus.cloudsim.power.models.PowerModelSpecPowerXeonX5350;
import org.cloudbus.cloudsim.power.models.PowerModelZF;
//import org.cloudbus.cloudsim.power.models.PowerModelSpecPowerHpProLiantMl110G4Xeon3040;
//import org.cloudbus.cloudsim.power.models.PowerModelSpecPowerHpProLiantMl110G5Xeon3075;
import org.cloudbus.cloudsim.power.models.PowerModelMy;

/**
 * If you are using any algorithms, policies or workload included in the power package, please cite
 * the following paper:
 * 
 * Anton Beloglazov, and Rajkumar Buyya, "Optimal Online Deterministic Algorithms and Adaptive
 * Heuristics for Energy and Performance Efficient Dynamic Consolidation of Virtual Machines in
 * Cloud Data Centers", Concurrency and Computation: Practice and Experience, ISSN: 1532-0626, Wiley
 * Press, New York, USA, 2011, DOI: 10.1002/cpe.1867
 * 
 * @author Anton Beloglazov - IBM R&D Australia
 * @since Jan 6, 2012
 */
public class Constants {

	public final static boolean ENABLE_OUTPUT = true;
	public final static boolean OUTPUT_CSV    = false;

	public  static double SCHEDULING_INTERVAL = 300;
	public  static double SIMULATION_LIMIT = 24 * 60 * 60;

	public static int CLOUDLET_LENGTH	= 2500 * (int) SIMULATION_LIMIT;
	public  static int CLOUDLET_PES	= 1; 
	
	//BestResource, FirstResource, BestPower
	//public final static String Order = "BestPower";
	public  static String Order = "BestPower";
	public static String StorageType = "NAS";
	/*
	 * VM instance types:
	 *   High-Memory Extra Large Instance: 3.25 EC2 Compute Units, 8.55 GB // too much MIPS
	 *   High-CPU Medium Instance: 2.5 EC2 Compute Units, 0.85 GB
	 *   Extra Large Instance: 2 EC2 Compute Units, 3.75 GB
	 *   Small Instance: 1 EC2 Compute Unit, 1.7 GB
	 *   Micro Instance: 0.5 EC2 Compute Unit, 0.633 GB
	 *   We decrease the memory size two times to enable oversubscription
	 *
	 */
	public  static int VM_TYPES	= 3;
	public  static int[] VM_MIPS	= { 1500, 1000, 500, 500 };
	public  static int[] VM_PES	= { 1, 1, 1, 1 };
//	public final static int[] VM_RAM	= { 4096,  2048, 1024, 1024 };
	public  static int[] VM_RAM	= { 4000,  2000, 1000, 1024 };
	public  static int VM_BW		= 100000; // 100 Mbit/s
	public  static int VM_SIZE		= 2500; // 2.5 GB

	/*
	 * Host types:
	 *   HP ProLiant ML110 G4 (1 x [Xeon 3040 1860 MHz, 2 cores], 4GB)
	 *   HP ProLiant ML110 G5 (1 x [Xeon 3075 2660 MHz, 2 cores], 4GB)
	 *   We increase the memory size to enable over-subscription (x4)
	 */
//	public final static int HOST_TYPES	 = 2;
	public  static int HOST_TYPES	 = 2;  //Host_Power
//	public final static int[] HOST_MIPS	 = { 1860, 2660 };
	public  static int[] HOST_MIPS	 = { 2660, 3660 };
	public  static int[] HOST_PES	 = { 1, 1 };
	public  static int[] HOST_RAM	 = { 20000, 30000 };
	public  static int HOST_BW		 = 1000000; // 1 Gbit/s
	public  static int HOST_STORAGE = 1000000; // 1 TB
    
	public  static boolean LIMIT_VM_NUM = false; 
	public  static int HOST_VM_MAX_NUM = 4;    // zhangfei 20121227
	
	public  static String workload_path = "";
	

	
	
	public final static PowerModel[] HOST_POWER = {
//		new PowerModelSpecPowerHpProLiantMl110G4Xeon3040(),
//		new PowerModelSpecPowerHpProLiantMl110G5Xeon3075()
		//new PowerModelZF(),
		new PowerModelMy(),
		new PowerModelZF()
		//new PowerModelSpecPowerXeonX5350()
	};
	

}
