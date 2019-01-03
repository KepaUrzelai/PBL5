package control;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;

import clases.Product;
import clases.Segment;
import clases.Vehicle;
import clases.Workstation;

public class ControlVehicles {
	
	static Semaphore mutEx;
	List<Vehicle> listVehicles;
	List<Vehicle> listAvailableVehicles;
	
	public ControlVehicles() {
		initVehicles();
		mutEx = new Semaphore(1);
		
	}
	
	private void initVehicles() {
		listVehicles= new ArrayList<Vehicle>();
		listAvailableVehicles= new ArrayList<Vehicle>();
		Vehicle vehicle0=new Vehicle(0, this);
		Vehicle vehicle1=new Vehicle(1, this);
		Vehicle vehicle2=new Vehicle(2, this);
		Thread thread0= new Thread(vehicle0);
		Thread thread1= new Thread(vehicle1);
		Thread thread2= new Thread(vehicle2);
		thread0.start();
		thread1.start();
		thread2.start();
		listVehicles.add(vehicle0);
		listVehicles.add(vehicle1);
		listVehicles.add(vehicle2);	
		listAvailableVehicles=listVehicles;
	}

	public void addVehicle(Vehicle vehicle) throws InterruptedException {
		mutEx.acquire();
		listAvailableVehicles.add(vehicle);
		mutEx.release();
		
	}

	public void callVehicle(Product product, Workstation workstation){
		try {
			mutEx.acquire();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Vehicle vehicle;
		while(listAvailableVehicles.size()==0) {			
		}
		vehicle=listAvailableVehicles.get(0);
		listAvailableVehicles.remove(0);
		workstation.setProductTaken(true);
		mutEx.release();
	//	vehicle.moveProduct(product);
		
		synchronized(vehicle) {
			vehicle.notify();
		}
		
		
	/*	try {
			vehicle.move(product);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
	}
	
/*	public void calcularRutaGeneral(Segment origin, Segment destination) {
		List<Integer> ruta = new ArrayList<>();	
		while(true) {
			ruta.add(origin.getNextSegment());		
			if(origin.getNextSegment2()!=-1){
					
			}
				
		}
		
	}
	
	public void calcularRutaSinDesvios(List<Integer> ruta, Segment segment, Segment destination) {
		while(segment.getNextSegment()==destination.getId()) {
			ruta.add(segment.getNextSegment());
			//aqui una funcion de pillar el siguiente segment en plan utilizando su id. con la base de datos que todavia no esta implementada
		}		
	}*/

}
