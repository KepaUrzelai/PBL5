package clases;

public abstract class Segment implements Runnable{
	
	int ID;

	
	public Segment(int id) {
		this.ID=id;
		
	}


	public int getID() {
		return ID;
	}


	public abstract void run();


}
