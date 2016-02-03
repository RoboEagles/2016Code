/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.RoboEagles4579.math;

/**
 *
 * @author bstevens
 */
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
    
}
