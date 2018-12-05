package clases;

public class Vehicle {
	
	int ID;
	Segment currentSegment, nextSegment;
	
	public Vehicle(int id, Segment current, Segment next) {
		this.ID=id;
		this.currentSegment=current;
		this.nextSegment=next;
	}

}
