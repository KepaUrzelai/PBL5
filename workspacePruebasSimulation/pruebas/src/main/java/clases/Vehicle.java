package clases;

import control.ControlVehicles;

public class Vehicle implements Runnable{
	
	int ID;
	Segment currentSegment, nextSegment;
	ControlVehicles controlVehicles;
	boolean waiting;
	
	public Vehicle(int id, ControlVehicles control) {//aqui se tendra que inicializar tmb con el current segment, pero de momento pa no tener que andar pasando la lista de segments pues no se hace. cuando este la base de datos echa se hace.
		this.ID=id;
		this.controlVehicles=control;
		this.waiting=true;
	}

	public void run() {
	/*	waiting();*/
	}
	
	private void waiting() {
		/*while(this.waiting) {
			
		}
		move();*/
	}

	public void move(Product product) {
		try {
			
			controlVehicles.moveVehicle(this.ID, product);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void setWaiting(boolean waiting) {
		this.waiting = waiting;
		System.out.println("llega");
	}
	

}
