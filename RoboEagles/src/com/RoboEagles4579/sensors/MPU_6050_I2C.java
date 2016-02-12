package com.RoboEagles4579.sensors;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

import com.RoboEagles4579.math.Vector3d;
import com.RoboEagles4579.math.Vector3i;

import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.SensorBase;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.communication.FRCNetworkCommunicationsLibrary.tInstances;
import edu.wpi.first.wpilibj.communication.FRCNetworkCommunicationsLibrary.tResourceType;
import edu.wpi.first.wpilibj.communication.UsageReporting;
import edu.wpi.first.wpilibj.interfaces.Accelerometer;
import edu.wpi.first.wpilibj.interfaces.Accelerometer.Range;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.livewindow.LiveWindowSendable;
import edu.wpi.first.wpilibj.tables.ITable;

public class MPU_6050_I2C {
	
	private byte deviceAddress;
	
	private int accelSensitivity = 0,
				gyroSensitivity = 0,
				sampleRateDivider = 19,
				digitalLPFConfig = 3;
	
	private Vector3i rawAccelerometer = new Vector3i(),
					 rawGyro = new Vector3i();
	
	private Vector3d accelValues = new Vector3d(),
					 gyroValues = new Vector3d();
	
	private double accelLSB_Sensitivity = ACCEL_SENSITIVITY[accelSensitivity][1],
				   gyroLSB_Sensitivity = GYRO_SENSITIVITY[gyroSensitivity][1];
	
	private static final int REGISTER_PWRMGMT_1 = 0x6B,
							 REGISTER_PWRMGMT_2 = 0x6C,
							 REGISTER_ACCEL = 0x3B,
							 REGISTER_GYRO = 0x43,
							 REGISTER_CONFIG = 0x1A,
							 REGISTER_GYRO_CONFIG = 0x1B,
							 REGISTER_ACCEL_CONFIG = 0x1C,
							 REGISTER_SAMPLE_RATE = 0x19;
	
	private static final double[][] ACCEL_SENSITIVITY = {
			{ 2. , 16384. },{ 4. , 8192. },{ 8. , 4096. },{ 16. , 2048. },
	};
	private static final double[][] GYRO_SENSITIVITY = {
			{ 250 , 131. },{ 500. , 65.5 },{ 1000. , 32.8 },{ 2000. , 16.4 },
	};
	
	public enum ACCEL_VALUES {
		
		k2g(0), k4g(1), k8g(2), k16g(3);
		
		private ACCEL_VALUES(int settingValue) {
			this.value = settingValue;
		}
		
		public int value;
		
	}
	
	public enum GYRO_VALUES {
		
		k250(0), k500(1), k1000(2), k2000(3);
		
		private GYRO_VALUES(int settingValue) {
			this.value = settingValue;
		}
		
		public int value;
		
	}
	
	private I2C MPU;
	
	public MPU_6050_I2C(byte deviceAddress, 
						ACCEL_VALUES accelSensitivity, 
						GYRO_VALUES gyroSensitivity) {
	
		this.accelSensitivity = accelSensitivity.value;
		this.gyroSensitivity = gyroSensitivity.value;
		this.deviceAddress = deviceAddress;
		
		this.accelLSB_Sensitivity = ACCEL_SENSITIVITY[this.accelSensitivity][1];
		this.gyroLSB_Sensitivity = GYRO_SENSITIVITY[this.gyroSensitivity][1];
		
		MPU = new I2C(I2C.Port.kOnboard, (int) this.deviceAddress);
		
	}

	public MPU_6050_I2C(byte deviceAddress) {
		
		this(deviceAddress, ACCEL_VALUES.k2g, GYRO_VALUES.k500);
		
		
	}

	public MPU_6050_I2C() {
		
		this((byte) 0x68);
		
	}
	
	private void init() {
		
		byte[] registerConfig = new byte[1];
		
		MPU.read(REGISTER_CONFIG, 1, registerConfig);
		registerConfig[0] = (byte) ((registerConfig[0] & (byte) 248) | (byte) digitalLPFConfig);
		
		MPU.write(REGISTER_SAMPLE_RATE, (byte) sampleRateDivider);
		MPU.write(REGISTER_CONFIG, registerConfig[0]);
		
		
		
		
	}
	
	public void read() {
		
		
		
	}
	
	public Vector3d getAccel() {
		return accelValues.divide(this.accelLSB_Sensitivity);
	}
	
	public Vector3d getGyro() {
		return gyroValues.divide(this.gyroLSB_Sensitivity);
	}
	
	public double getAccelX() {
		return getAccel().X;
	}
	
	public double getAccelY() {
		return getAccel().Y;
	}
	
	public double getAccelZ() {
		return getAccel().Z;		
	}
	
	public double getGyroX() {
		return getGyro().X;
	}
	
	public double getGyroY() {
		return getGyro().Y;
	}
	
	public double getGyroZ() {
		return getGyro().Z;
	}
	

}
