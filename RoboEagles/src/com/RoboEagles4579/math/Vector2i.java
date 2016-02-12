package com.RoboEagles4579.math;

public class Vector2i {
	
    public int X, Y;
    
    public Vector2i(int x, int y) {
        this.X = x;
        this.Y = y;
    }
    
    public double magnitude() { //Returns magnitude of vector
        return Math.sqrt(X*X + Y*Y);
    }
    
    public void reset() {
        X = 0;
        Y = 0;
    }
    
    public void multiply(int val) {
    	
    	X *= val;
    	Y *= val;
    	
    }

}
