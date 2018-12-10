package clases;

import control.ControlVehicles;

public class Parking extends Segment{
	
	Line correspondientLine;

	public Parking(int id, Line correspondient, ControlVehicles control) {
		super(id, control);
		// TODO Auto-generated constructor stub
		this.correspondientLine=correspondient;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}

}
