
/*
 * Property of FRC TEAM 4579 - RoboEagles
 * v1.0 | 03/19/2015
 * Lead Programmer, Jaden Bottemiller
 * 
 * This class is intended to be used as a second order low pass filter for inputs to another system.
 * For example: a joystick input to a motor controller
 * 
 * The output of the filter() method is what needs to be fed into the other system
 * E.G. motor.filter(1);
 *
 * The coefficients involved are calculated very precisey, and are very sensitive to changes
 * A change by one-hundredth of a decimal place can drastically affect the output of the filter
 * It is advised to let the class calculate its own coefficients given a cutoff frequency and a 
 * bandwidth for the input frequency
 */
package com.RoboEagles4579.filters;

public class SecondOrderLPF {
	
	private double[] lastOutputs = {0.,0.}, // Last stored filtered output
					 lastInputs = {0.,0.}, // Last stored filter inputs
					 coefficients = {0.,0.,0.,0.,0.}; // Coefficients for the low pass filter calculation (see filter() for use)
	
	/*
	 * This constructor sets the coefficients for the low pass filter
	 * The filter coefficients are used in the low pass filter calculation (see filter() for use)
	 * @param double[] setCoefficients An array of coefficients for the low pass filter calculation
	 */
	public SecondOrderLPF(double[] setCoefficients) {
		setLPFCoefficients(setCoefficients);
	}
	
	/*
	 * 
	 * This constructor sets the low pass filter coefficients without using an array
	 * 
	 * @param double a The first coefficient value (five total coefficients)
	 * @param double b The second coefficient value (five total coefficients)
	 * @param double c The third coefficient value (five total coefficients)
	 * @param double d The fourth coefficient value(five total coefficients)
	 * @param double e the fifth coefficient value (five total coefficients)
	 */
	public SecondOrderLPF(double a, double b, double c, double d, double e) {
		setLPFCoefficients(a,b,c,d,e);
	}
	
	/*
	 * This constructor attempts to calculate the coefficients itself using Fo and Bw
	 * 
	 * @param double fo Cutoff Frequency for the filter
	 * @param double bw Width of the filter passband, should be greater than fo for critical damping
	 */
	public SecondOrderLPF(double fo, double bw) {
		setLPFCoefficients(fo, bw);
	}
	
	/*
	 * This constructor attempts to calculate the coefficients itelf be using a default cutoff frequency and filter passband width
	 */
	public SecondOrderLPF() {
		setLPFCoefficients();
	}
	
	/* Main filter method for the low pass filter mechanism.
	 * Input a value, Output the filtered value (this will filter based on the last stored value)
	 * @param double input The input to filter.
	 */
	public double filter(double input) {
		
		//Math for finding the new output
		double output = (input*coefficients[0]) + (coefficients[1] * lastInputs[1]) + (coefficients[2] * lastInputs[0]) - 
						(coefficients[3] * lastOutputs[1]) - (coefficients[4] * lastOutputs[0]);
		
		//Set last output values for LPF Calculation
		lastOutputs[0] = lastOutputs[1];
		lastOutputs[1] = output;
		//Set last input values for LPF Calculation
		lastInputs[0] = lastInputs[1];
		lastInputs[1] = input;
		
		
		return output;
	}
	
	/*
	 * This method hard sets the low pass filter coefficients without reconstructing the filter
	 * 
	 * @param double[] setCoefficients An array of coefficients for the low pass filter calculation
	 */
	public void setLPFCoefficients (double[] setCoefficients) {
		coefficients = setCoefficients.clone();
	}
	
	/*
	 * This method hard sets the low pass filter coefficients without using an array or reconstructing the filter
	 * 
	 * @param double a The first coefficient value (five total coefficients)
	 * @param double b The second coefficient value (five total coefficients)
	 * @param double c The third coefficient value (five total coefficients)
	 * @param double d The fourth coefficient value(five total coefficients)
	 * @param double e the fifth coefficient value (five total coefficients)
	 */
	public void setLPFCoefficients(double a, double b, double c, double d, double e) {
		double[] setCoefficients = {a,b,c,d,e};
		coefficients = setCoefficients.clone();
	}
	
	/*
	 * This method attempts to calculate the coefficients itself using Fo and Bw or reconstructing the filter
	 * 
	 * @param double fo Cutoff Frequency for the filter
	 * @param double bw Width of the filter passband, should be greater than fo for critical damping
	 */
	public void setLPFCoefficients(double fo, double bw) {
		setCoefficients(fo, bw);
	}
	
	/*
	 * This method attempts to calculate the coefficients itself by using default cutoff frequency and filter passband width or reconstructing the filter
	 */
	public void setLPFCoefficients() {
		setCoefficients(2, 2.2);
	}
	
	/*
	 * This method returns an array of the coefficients as they are currently set
	 */
	public double[] getCoefficients() {
		return coefficients;
	}
	
	/*
	 * This method hard resets the stored outputs and the stored inputs of the filter
	 */
	public void reset() {
		double[] empty = {0.,0.};
		lastOutputs = empty.clone();
		lastInputs = empty.clone();
	}
	
	/*
	 * This method is meant to isolate the setCoefficients calculation from the rest of the class
	 */
	private void setCoefficients(double fo, double bw)  {
		//calculate all the coefficients from inputs
		//declare all variables
		double  fs, // digital sampling frequency which must be at least 2 time the Nyquist frequency
				alpha, //relationship between corner frequency and bandwidth 
				Wo, // fo (Digital Cutoff Frequency) in radians per second
				bo,
				b1,
				b2,
				ao,
				a1,
				a2;
		//Declare end coefficient variables
		double  c1,
				c2,
				c3,
				c4,
				c5;
		// Set fs 
		fs = 50.0; // Default Fs = 50
		// Find Wo
		Wo = 2*Math.PI*(fo / fs);
		// Set alpha
		alpha = Math.sin(Wo)*Math.sinh(Math.log(2)/2*bw*Wo/Math.sin(Wo));
		// Set b coefficients
		bo = (1-Math.cos(Wo))/2.0;
		b1 = (1-Math.cos(Wo));
		b2 = (1-Math.cos(Wo))/2.0;
		//Set a coefficients
		ao = 1 + alpha;
		a1 = -2*Math.cos(Wo);
		a2 = 1 - alpha;
		//Set final coefficients
		c1 = bo / ao;
		c2 = b1 / ao;
		c3 = b2 / ao;
		c4 = a1 / ao;
		c5 = a2 / ao;
		
		double[] setCoefficients = {c1, c2, c3, c4, c5};
		
		coefficients = setCoefficients.clone();
		
	}


}
