package control;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;

import clases.Product;
import clases.Vehicle;

public class ControlVehicles {
	
	static Semaphore vehicle;
	List<Vehicle> listVehicles;
	List<Vehicle> listAvailableVehicles;
	
	public ControlVehicles() {
		initVehicles();
		vehicle = new Semaphore(2);
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

	public void moveVehicle(int id, Product product) throws InterruptedException {
		vehicle.acquire();
		System.out.println("El vehiculo=" + id + " ha pillau el producto=" + product.getName());
		Thread.sleep(5000);
		System.out.println("Se ha entregado el producto. El vehiculo vuelve a estar disponible.");
		vehicle.release();
		
	}

	public boolean callVehicle(Product product) {
	//	listAvailableVehicles.get(0).setWaiting(false);
		listAvailableVehicles.get(0).move(product);
		return true;
	}

}
