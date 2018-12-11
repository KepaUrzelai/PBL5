package clases;

import control.ControlVehicles;

public class Vehicle implements Runnable{
	
	int ID;
	Segment currentSegment, nextSegment;
	ControlVehicles controlVehicles;
	boolean waiting;
	Product productToMove;
	
	public Vehicle(int id, ControlVehicles control) {//aqui se tendra que inicializar tmb con el current segment, pero de momento pa no tener que andar pasando la lista de segments pues no se hace. cuando este la base de datos echa se hace.
		this.ID=id;
		controlVehicles=control;
		this.waiting=true;
	}

	public void move(Product product) throws InterruptedException {
		try {
			System.out.println("El vehiculo=" + this.ID + " ha pillau el producto=" + product.getName());
			Thread.sleep(6000);
			System.out.println("Se ha entregado el producto. El vehiculo vuelve a estar disponible.");
			controlVehicles.addVehicle(this);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		waiting();
	}

	public void moveProduct(Product product) {
		this.productToMove = product;
	}

	public int getID() {
		return ID;
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
		move(this.productToMove);
	}
	

}
