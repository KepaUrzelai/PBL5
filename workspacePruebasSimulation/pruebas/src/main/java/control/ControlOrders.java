package control;

import java.util.List;

import clases.Order;
import clases.Product;
import clases.Workstation;

public class ControlOrders {
	
	public ControlOrders() {
		//el init threads tendriamos que hacerlo aqui inicializando todos los threads. Luego un while en el 
		//run de los threads esperando a que llegue un orden.
	}
	
	
	public void addOrder(Order order) {
		List<Product> productList;
		productList=order.getProductList();
		for(int i=0;i<productList.size();i++) {
			addToWorkspace(productList.get(i), productList.get(i).getSegmentOrigin());			
		}		
		initThreads(order);
	}
	
	private void initThreads(Order order) {//esto esta mal, hay que crearlos pillando de la lista de los segmentos. que luego he estado con errores
		List<Product> productList;
		productList=order.getProductList();
		Thread thread=new Thread(order.getProductList().get(0).getSegmentOrigin());
		thread.setName("thread" + 1);
			
		Thread thread1=new Thread(order.getProductList().get(3).getSegmentOrigin());
		thread1.setName("thread" + 2);
		
		thread.start();	
		thread1.start();	
			
	}


	private void addToWorkspace(Product product, Workstation workstation) {
		workstation.addProduct(product);
	}

}
