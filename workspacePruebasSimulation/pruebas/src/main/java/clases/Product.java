package clases;

public class Product {
	
	int ID;
	Workstation segmentOrigin, segmentDestination;
	int time;
	String name;
	
	public Product(int id,String name, Workstation origin, Workstation desti, int time) {
		this.ID=id;
		this.segmentDestination=desti;
		this.segmentOrigin=origin;
		this.time=time;
		this.name=name;
	}

	public Workstation getSegmentOrigin() {
		return segmentOrigin;
	}

	public Workstation getSegmentDestination() {
		return segmentDestination;
	}

	public int getTime() {
		return time;
	}

	public String getName() {
		return name;
	}

}
