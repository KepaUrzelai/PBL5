package clases;

public class Parking extends Segment{
	
	Line correspondientLine;

	public Parking(int id, Line correspondient) {
		super(id);
		// TODO Auto-generated constructor stub
		this.correspondientLine=correspondient;
	}

}
