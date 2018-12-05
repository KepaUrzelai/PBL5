package clases;

public class Parking extends Segment{
	
	Line correspondientLine;

	public Parking(int id, Line correspondient) {
		super(id);
		// TODO Auto-generated constructor stub
		this.correspondientLine=correspondient;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}

}
