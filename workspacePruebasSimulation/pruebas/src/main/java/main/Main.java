package main;

import java.util.ArrayList;
import java.util.List;

import clases.Line;
import clases.Order;
import clases.Parking;
import clases.Product;
import clases.Segment;
import clases.Workstation;
import control.ControlOrders;
import control.ControlVehicles;

public class Main {
	
	List<Segment> SegmentList;
	List<Product> order1;
	Order order;
	ControlOrders controlOrders;
	ControlVehicles controlVehicles;
	
	public Main() {
		
		controlVehicles=new ControlVehicles();
		inicializar();
		addOrder();
	}
	
    private void addOrder() {
		controlOrders=new ControlOrders();
		System.out.println(order.getProductList().get(0));
		controlOrders.addOrder(order);
		
	}

	public static void main(String[] args) throws Exception {

    	@SuppressWarnings("unused")
		Main main= new Main();
 
    	
    }


	public void inicializar() {
    	inicializarSegmentos();
    	inicializarOrders();
    }
    
    private void inicializarOrders() {
    	order1=new ArrayList<Product>();
    	order1.add(new Product(0,"alfajores 1", (Workstation)SegmentList.get(8), (Workstation)SegmentList.get(7), 5));
    	order1.add(new Product(1,"alfajores 2", (Workstation)SegmentList.get(8), (Workstation)SegmentList.get(7), 5));
    	order1.add(new Product(2,"alfajores 3", (Workstation)SegmentList.get(8), (Workstation)SegmentList.get(7), 5));
    	order1.add(new Product(3,"dildo 1", (Workstation)SegmentList.get(9), (Workstation)SegmentList.get(7), 7));
    	order1.add(new Product(4,"dildo 2", (Workstation)SegmentList.get(9), (Workstation)SegmentList.get(7), 7));
		order=new Order(1, order1);
	}

	private void inicializarSegmentos() {
		SegmentList=new ArrayList<Segment>();
    	SegmentList.add(new Line(0, 1, 2, controlVehicles));//-1 equivale a null
    	SegmentList.add(new Line(1, 3, -1, controlVehicles));
    	SegmentList.add(new Line(2, 5, -1, controlVehicles));
    	SegmentList.add(new Line(3, 4, -1, controlVehicles));
    	SegmentList.add(new Line(4, 5, -1, controlVehicles));
    	SegmentList.add(new Line(5, 6, -1, controlVehicles));
    	SegmentList.add(new Line(6, 0, -1, controlVehicles));
     	SegmentList.add(new Workstation(10,"workspace 1", (Line) SegmentList.get(0), controlVehicles));
     	SegmentList.add(new Workstation(11,"workspace 2", (Line) SegmentList.get(4), controlVehicles));
     	SegmentList.add(new Workstation(12,"workspace 3", (Line) SegmentList.get(4), controlVehicles));//este lo he creau para tener otro mas y para hacer pruebas. no cuadra con el esquema
     	SegmentList.add(new Parking(20, (Line) SegmentList.get(1), controlVehicles));
    	
    }

}
