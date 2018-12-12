package clases;

import control.ControlVehicles;

public class Line extends Segment{
	
	int nextSegment, nextSegment2;

	public Line(int id, int nextSegment, int nextSegment2, ControlVehicles control) {
		super(id, control);
		// TODO Auto-generated constructor stub
		
		this.nextSegment=nextSegment;
		this.nextSegment2=nextSegment2;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}

	public int getNextSegment() {
		return nextSegment;
	}

	public int getNextSegment2() {
		return nextSegment2;
	}

}
