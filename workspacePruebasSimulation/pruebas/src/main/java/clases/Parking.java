package clases;

import control.ControlVehicles;

public class Parking extends Segment{
	
/*	int correspondientLineId;
	String name;*/

	public Parking(int id,String name, int correspondient, ControlVehicles control) {
		super(id, control);
		// TODO Auto-generated constructor stub
		this.name=name;
		this.correspondientLineId=correspondient;
	}

	public int getCorrespondientLineId() {
		return correspondientLineId;
	}

	public String getName() {
		return name;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}

}
