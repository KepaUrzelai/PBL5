package clases;

import control.ControlVehicles;

public abstract class Segment implements Runnable{
	
	int ID;
	
	ControlVehicles controlVehicles;

	
	public Segment(int id, ControlVehicles control) {
		this.ID=id;
		this.controlVehicles=control;
		
	}


	public int getID() {
		return ID;
	}


	public abstract void run();


}
