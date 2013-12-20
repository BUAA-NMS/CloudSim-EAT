package org.cloudbus.cloudsim.examples.power.planetlab;

import java.io.IOException;

/**
 * A simulation of a heterogeneous power aware data center that applies the Median Absolute
 * Deviation (MAD) VM allocation policy and Maximum Correlation (MC) VM selection policy.

 * @since Jan 5, 2012
 */
public class URS {

	/**
	 * The main method.
	 * 
	 * @param args the arguments
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public static void main(String[] args) throws IOException {
		boolean enableOutput = false;
		boolean outputToFile = false;
		//String inputFolder = MadMc.class.getClassLoader().getResource("workload/planetlab").getPath();
		String inputFolder = MadMc.class.getClassLoader().getResource("workload").getPath();
		String outputFolder = String.valueOf(PlanetLabConstants.NUMBER_OF_HOSTS);
		String workload = "L"; // PlanetLab workload
		String vmAllocationPolicy = "mad"; // Median Absolute Deviation (MED) VM allocation policy
		String vmSelectionPolicy = "mc"; // Maximum Correlation (MC) VM selection policy
		String parameter = "2.5"; // the safety parameter of the MED policy 

		new PlanetLabRunner(
				enableOutput,
				outputToFile,
				inputFolder,
				outputFolder,
				workload,
				vmAllocationPolicy,
				vmSelectionPolicy,
				parameter);
	}
}
