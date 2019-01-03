package clases;

import control.ControlVehicles;

public class Line extends Segment{
	

	public Line(int id, int nextSegment, int nextSegment2, ControlVehicles control) {
		super(id, control);
		// TODO Auto-generated constructor stub
		
		this.nextSegment=nextSegment;
		this.nextSegment2=nextSegment2;
	}

	@Override
	public void run() {
		try {
			waiting();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	
	private void waiting() throws InterruptedException {
		synchronized(this) {
			this.wait();
		}		
		
	}

	public int getNextSegment() {
		return nextSegment;
	}

	public int getNextSegment2() {
		return nextSegment2;
	}

}
