package clases;

import java.util.ArrayList;
import java.util.List;

public class Workstation extends Segment{
	
	Line correspondientLine;
	String name;
	List<Product> listaProductos;

	public Workstation(int id,String name, Line correspondient) {
		super(id);
		// TODO Auto-generated constructor stub
		this.correspondientLine=correspondient;
		this.listaProductos=new ArrayList<Product>();
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

	public void deleteProduct() {
		listaProductos.remove(0);
		
		if(listaProductos.size()!=0) {
			makeProduct();
		}
	}

	@Override
	public void run() {
		makeProduct();
		System.out.println("viene el vehiculo a llevarse un producto");
		deleteProduct();
		
	}
}
