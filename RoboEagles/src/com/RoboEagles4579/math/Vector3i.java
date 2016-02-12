package com.RoboEagles4579.math;

public class Vector3i extends Vector2i {

	public int Z;

	public Vector3i(int x, int y, int z) {
		super(x, y);
		this.Z = z;
	}

	public Vector3i() {
		this(0, 0, 0);
	}

	public double magnitude() {// Returns magnitude of the vector
		return Math.sqrt(X * X + Y * Y + Z * Z);
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
