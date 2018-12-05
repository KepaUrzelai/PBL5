package clases;

import java.util.List;

public class Order {
	
	int ID;
	List<Product> productList;
	
	
	public Order(int id, List<Product> productList){
		this.ID=id;
		this.productList=productList;		
	}


	public int getID() {
		return ID;
	}


	public List<Product> getProductList() {
		return productList;
	}
	
	

}
