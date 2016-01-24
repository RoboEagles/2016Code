package com.RoboEagles4579.filters;

public class AverageFilter {
	
	private int arrayCount;
	private double[] averageArray;
	
	public AverageFilter(int arrayCount) {
		this.arrayCount = arrayCount;
		averageArray = new double[arrayCount];		
		
		fillArray();
	}
	
	public double filter(double input) {
		double output = 0;
		
		this.averageArray = shiftArray(input);
		
		output = arraySum() / arrayCount;
		
		
		return output;
	}
	
	private double[] shiftArray(double newValue) {
		double[] output = new double[arrayCount];
		
		for(int i = 0; i < (averageArray.length - 1); i++){
			output[i] = averageArray[i+1];
		}
		
		output[averageArray.length - 1] = newValue;
		
		return output;
	}
	
	private double arraySum() {
		double sum = 0;
		for(int i = 0; i<(averageArray.length); i++) {
			sum += averageArray[i];
		}
		return sum;
	}
	
	private void fillArray(double fillValue) {
		for(int i = 0; i < averageArray.length; i++) {
			averageArray[i] = fillValue;
		}
	}
	
	private void fillArray() {
		this.fillArray(0);
	}

}
