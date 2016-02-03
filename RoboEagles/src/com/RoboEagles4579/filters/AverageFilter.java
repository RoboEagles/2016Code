package com.RoboEagles4579.filters;

public class AverageFilter {
	
	private int arraySize,
				index,
				lastIndex;
	
	private double average,
					sum;
	
	private double[] array;
	
	public AverageFilter(int arraySize) {
		this.arraySize = arraySize;
		array = new double[arraySize];
		for(int i = 0; i < array.length; i++){
			array[i] = 0;
		}
		sum = 0.;
		lastIndex = 0;
		index = 0;
	}
	
	public double filter(double input) {
		
		lastIndex = lastIndex - 1 < 0 ? arraySize - 1 : lastIndex - 1;
		
		
		sum -= array[lastIndex];
		sum += input;
		
		array[index] = input;
		
		index = index + 1 >= arraySize ? index = 0 : index + 1;
		
		average = sum / arraySize;
		
		return average;
		
	}
	
	public double getAverage() {
		return average;
	}
	
}
