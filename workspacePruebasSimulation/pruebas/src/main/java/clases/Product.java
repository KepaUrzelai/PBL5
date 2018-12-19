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
	
	int time;
	String name;
	
	public Product(int id,String name, Workstation origin, Workstation desti, int time) {
		this.id=id;
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
