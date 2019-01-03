package clases;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import control.ControlVehicles;

public class Vehicle implements Runnable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private Integer id;
	
	@OneToOne
	@JoinColumn(name = "currentSegment")
	private Segment currentSegment;
	
	@OneToOne
	@JoinColumn(name = "nextSegment")
	private Segment nextSegment;
	
	@Column(name = "status")
	private String status;
	
	ControlVehicles controlVehicles;
	boolean waiting;
	Product productToMove;
	
	public Vehicle(int id, ControlVehicles control) {//aqui se tendra que inicializar tmb con el current segment, pero de momento pa no tener que andar pasando la lista de segments pues no se hace. cuando este la base de datos echa se hace.
		this.id=id;
		controlVehicles=control;
		this.waiting=true;
	}

	public void move(Product product) throws InterruptedException {
	//	System.out.println("El vehiculo=" + this.id + " ha pillau el producto=" + product.getName());
		System.out.println("ha pillau el product");
		Thread.sleep(6000);
		System.out.println("Se ha entregado el producto. El vehiculo vuelve a estar disponible.");
		controlVehicles.addVehicle(this);
		waiting();
	}

	public void moveProduct(Product product) {
		this.productToMove = product;
	}

	public int getID() {
		return id;
	}

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
//		calcularRuta();
		move(this.productToMove);
	}

/*	private void calcularRuta() {
		controlVehicles.calcularRutaGeneral(this.productToMove.getSegmentOrigin(), this.productToMove.getSegmentDestination());
		
	}*/
	

}
