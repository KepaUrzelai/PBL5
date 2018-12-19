package clases;

public class Product {
	/**
	 * @class The class for products, it is formed by an identificator(ID),
	 * an origin segment from which it comes ,a destination segment where it has to go to be shipped
	 * A name to descript the product itself and the time that takes to the workstation to make that product.
	 * */
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
	
	/**
	 * 
	 * 
	 */
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
