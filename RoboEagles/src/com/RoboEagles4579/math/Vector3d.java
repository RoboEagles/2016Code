/*
 * Property of FRC TEAM 4579 - RoboEagles
 * v1.0 | 03/19/2015
 * Lead Programmer, Jaden Bottemiller
 */

package com.RoboEagles4579.math;


public class Vector3d extends Vector2d {
    
    public double Z;
    
    public Vector3d(double x, double y, double z) {
        super(x,y);
        this.Z = z;
    }
    
    public Vector3d() {
    	this(0,0,0);
	}

	public double magnitude() {//Returns magnitude of the vector
        return Math.sqrt(X*X + Y*Y + Z*Z);
    }
    
    public double angleXZ() {
        return Math.tan(X / Z);
    }
    
    public double angleYZ() {
        return Math.tan(Y / Z);
    }
    
    public void reset() {
        X = 0;
        Y = 0;
        Z = 0;
    }
    
    public Vector3d multiply(double val) {
    	super.multiply(val);
    	Z *= val;
    	return this;
    }
    
    public Vector3d divide(double val) {
    	super.divide(val);
    	Z /= val;
    	return this;
    }
    
}
