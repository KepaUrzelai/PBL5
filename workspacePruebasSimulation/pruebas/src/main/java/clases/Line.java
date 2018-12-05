package clases;

public class Line extends Segment{
	
	int nextSegment, nextSegment2;

	public Line(int id, int nextSegment, int nextSegment2) {
		super(id);
		// TODO Auto-generated constructor stub
		
		this.nextSegment=nextSegment;
		this.nextSegment2=nextSegment2;
	}

}
