package clases;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "product")
public class Product {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private Integer id;
		
	@Column(name = "price")
	private Integer price;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "status")
	private String status;
	
	@OneToOne
	@JoinColumn(name = "origin")
	private Workstation segmentOrigin;
	
	@OneToOne
	@JoinColumn(name = "destination")
	private Workstation segmentDestination;
	
	@OneToOne
	@JoinColumn(name = "userId")
	private Integer userId;
	
	@OneToOne
	@JoinColumn(name = "vehicleId")
	private Integer vehicleId;
	

	/**
	 * @class The class for products, it is formed by an identificator(ID),
	 * an origin segment from which it comes ,a destination segment where it has to go to be shipped
	 * A name to descript the product itself and the time that takes to the workstation to make that product.
	 * */

	int time;
	String name;
	
	public Product(int id,String name, Workstation origin, Workstation desti, int time) {
		this.id=id;
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
