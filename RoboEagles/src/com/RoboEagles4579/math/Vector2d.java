/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.RoboEagles4579.math;

public class Vector2d {

    public double X, Y;
    
    public Vector2d(double x, double y) {
        this.X = x;
        this.Y = y;
    }
    
    public double magnitude() { //Returns magnitude of vector
        return Math.sqrt(X*X + Y*Y);
    }
    
    public double angleXY() { //Returns vector angle in radians
        
        return Math.tan(Y / X); //Zero is compass east
        
    }
    
    public void reset() {
        X = 0;
        Y = 0;
    }
    
    public Vector2d multiply(double val) {
    	X *= val;
    	Y *= val;
    	return this;
    }

	public Vector2d divide(double val) {
		X /= val;
		Y /= val;
		return this;
		
		
	}
    
}
