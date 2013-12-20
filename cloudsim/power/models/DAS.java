package org.cloudbus.cloudsim.power.models;



public class DAS extends PowerModel{

	@Override
	public double getPower(double utilization) throws IllegalArgumentException {
		// TODO Auto-generated method stub
//		throw new Exception("no method");
		return 0;
	}

	public double getPower(double seqread,double seqwrite) throws IllegalArgumentException {

		if (seqread < 0 || seqwrite > 100 ) {
			throw new IllegalArgumentException("speed value must be between 0 and 100");
		}
		if (seqread == 0) {
			return 0;
		}
		double temp = 0.018466*seqread + 0.020039*seqwrite + 6.7281;
		
		return temp;
	}
}
