package com.RoboEagles4579.filters;

public class AverageFilter {
	
	private int arraySize,
				index;
	
	private double average,
					sum;
	
	private double[] array;
	
	public AverageFilter(int arraySize) {
		this.arraySize = arraySize;
		array = new double[arraySize];
		reset();
		sum = 0.;
		index = 0;
	}
	
	public double filter(double input) {

		sum -= array[index];
		array[index] = input;
		sum += input;

		index = index + 1 == arraySize ? 0 : index + 1;
		
		average = sum / (double) arraySize;
		
		return average;
		
	}
	
	public void reset() {
		for(int i = 0; i < array.length; i++) {
			array[i] = 0;			
		}
		index = 0;
		sum = 0;
	}
	
	public double getAverage() {
		return average;
	}
	
	public double getArraySize() {
		return arraySize;
	}
	
}
