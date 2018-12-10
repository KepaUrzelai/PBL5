package clases;

import java.util.ArrayList;
import java.util.List;

import control.ControlVehicles;

public class Workstation extends Segment{
	
	Line correspondientLine;
	String name;
	List<Product> listaProductos;
	boolean productTaken;

	public Workstation(int id,String name, Line correspondient, ControlVehicles control) {
		super(id, control);
		// TODO Auto-generated constructor stub
		this.correspondientLine=correspondient;
		this.listaProductos=new ArrayList<Product>();
		productTaken=false;
	}
	
	public void addProduct(Product product) {
		listaProductos.add(product);
		System.out.println(product.getName()+ " added to the workstation");
	}

	public boolean makeProduct() {
		if(listaProductos.size()!=0) {
			try {
				Thread.sleep(listaProductos.get(0).getTime()*1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(listaProductos.get(0).getName()+ " its ready!");
		}
		return true;

	}
	
	public void produce() {
		makeProduct();
		while(!productTaken) {		
			productTaken=controlVehicles.callVehicle(listaProductos.get(0));
		}
		deleteProduct();
	}
	
	public void deleteProduct() {
		listaProductos.remove(0);
		if(listaProductos.size()!=0) {
			produce();
		}
	}

	@Override
	public void run() {
		produce();	
	}
}
