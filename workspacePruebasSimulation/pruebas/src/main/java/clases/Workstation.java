package clases;

import java.util.ArrayList;
import java.util.List;

import control.ControlVehicles;

public class Workstation extends Segment{
	
	int correspondientLineId;
	String name;
	List<Product> listaProductos;
	boolean productTaken;

	public Workstation(int id,String name, int correspondient, ControlVehicles control) {
		super(id, control);
		// TODO Auto-generated constructor stub
		this.correspondientLineId=correspondient;
		this.listaProductos=new ArrayList<Product>();
		productTaken=false;
	}
	
	public void addProduct(Product product) {
		this.listaProductos.add(product);
		System.out.println(product.getName()+ " added to the workstation");
	}

	public boolean makeProduct() {
		if(this.listaProductos.size()!=0) {
			try {
				Thread.sleep(this.listaProductos.get(0).getTime()*1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(this.listaProductos.get(0).getName()+ " its ready!");
		}
		return true;

	}
	
	public void produce() {
		makeProduct();
		while(!this.productTaken) {		
			controlVehicles.callVehicle(listaProductos.get(0), this);
		}
		this.productTaken=false;
		deleteProduct();
	}
	
	public void deleteProduct() {
		this.listaProductos.remove(0);
		if(this.listaProductos.size()!=0) {
			produce();
		}
	}

	@Override
	public void run() {
		produce();	
	}

	public void setProductTaken(boolean productTaken) {
		this.productTaken = productTaken;
	}

	public int getCorrespondientLineId() {
		return correspondientLineId;
	}

	public String getName() {
		return name;
	}
	
}
