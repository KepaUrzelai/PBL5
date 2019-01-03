package main;

import java.util.ArrayList;
import java.util.List;

import clases.Line;
import clases.Order;
import clases.Parking;
import clases.Product;
import clases.Segment;
import clases.Workstation;
import clases.WorkstationJava;
import control.ControlOrders;
import control.ControlVehicles;
import segment.dao.SegmentItemFacade;

public class Main {
	
	List<WorkstationJava> listWorkstation;
	List<Segment> SegmentList;
	List<Product> order1;
	Order order;
	ControlOrders controlOrders;
	ControlVehicles controlVehicles;
	
	public Main() {
		
		controlVehicles=new ControlVehicles();
		inicializar();
		//addSegmentsToDatabase();
		addOrder();
	}
	
/*    private void addSegmentsToDatabase() {
    	SegmentItemFacade database= new SegmentItemFacade();
		for (Segment s: SegmentList) {
			database.saveSegment(s);
		}
	}*/

	private void addOrder() {
		controlOrders=new ControlOrders();
		controlOrders.addOrder(order);
		
	}

	public static void main(String[] args) throws Exception {

    	@SuppressWarnings("unused")
		Main main= new Main();
 
    	
    }


	public void inicializar() {
    	inicializarSegmentos();
    	inicializarOrders();
    	inicializarWorkstation();
    }
    
    private void inicializarWorkstation() {
		listWorkstation=new ArrayList<>();
		listWorkstation.add(new WorkstationJava((Workstation) SegmentList.get(17)));
		listWorkstation.add(new WorkstationJava((Workstation) SegmentList.get(18)));
		listWorkstation.add(new WorkstationJava((Workstation) SegmentList.get(19)));
		listWorkstation.add(new WorkstationJava((Workstation) SegmentList.get(20)));
		listWorkstation.add(new WorkstationJava((Workstation) SegmentList.get(21)));
		listWorkstation.add(new WorkstationJava((Workstation) SegmentList.get(22)));
	}

	private void inicializarOrders() {
    	order1=new ArrayList<Product>();
    	order1.add(new Product(0,"alfajores 1", (Workstation)SegmentList.get(18), (Workstation)SegmentList.get(17), 5));
    	order1.add(new Product(1,"alfajores 2", (Workstation)SegmentList.get(18), (Workstation)SegmentList.get(17), 5));
    	order1.add(new Product(2,"alfajores 3", (Workstation)SegmentList.get(18), (Workstation)SegmentList.get(17), 5));
    	order1.add(new Product(3,"perrunillas 1", (Workstation)SegmentList.get(19), (Workstation)SegmentList.get(17), 7));
    	order1.add(new Product(4,"perrunillas 2", (Workstation)SegmentList.get(19), (Workstation)SegmentList.get(17), 7));
		order=new Order(1, order1);
	}

	private void inicializarSegmentos() {
		SegmentList=new ArrayList<Segment>();
		
    	SegmentList.add(new Line(0, 1, 12, controlVehicles));//-1 equivale a null
    	SegmentList.add(new Line(1, 2, -1, controlVehicles));
    	SegmentList.add(new Line(2, 3, 14, controlVehicles));
    	SegmentList.add(new Line(3, 4, -1, controlVehicles));
    	SegmentList.add(new Line(4, 5, -1, controlVehicles));
    	SegmentList.add(new Line(5, 6, -1, controlVehicles));
    	SegmentList.add(new Line(6, 7, 15, controlVehicles));
    	SegmentList.add(new Line(7, 8, -1, controlVehicles));
    	SegmentList.add(new Line(8, 9, 13, controlVehicles));
    	SegmentList.add(new Line(9, 10, -1, controlVehicles));
    	SegmentList.add(new Line(10, 11, -1, controlVehicles));
    	SegmentList.add(new Line(11, 0, -1, controlVehicles));
    	SegmentList.add(new Line(12, 10, -1, controlVehicles));
    	SegmentList.add(new Line(13, 2, -1, controlVehicles));
    	SegmentList.add(new Line(14, 8, -1, controlVehicles));
    	SegmentList.add(new Line(15, 4, -1, controlVehicles));
    	
    	
     	SegmentList.add(new Workstation(20,"workspace 1",  SegmentList.get(0).getId(), controlVehicles));
     	SegmentList.add(new Workstation(21,"workspace 2",  SegmentList.get(2).getId(), controlVehicles));
     	SegmentList.add(new Workstation(22,"workspace 3",  SegmentList.get(4).getId(), controlVehicles));
     	SegmentList.add(new Workstation(23,"workspace 4",  SegmentList.get(6).getId(), controlVehicles));
     	SegmentList.add(new Workstation(24,"workspace 5",  SegmentList.get(8).getId(), controlVehicles));
     	SegmentList.add(new Workstation(25,"workspace 6",  SegmentList.get(10).getId(), controlVehicles));
     	
     	SegmentList.add(new Parking(30,"parking 1", SegmentList.get(1).getId(), controlVehicles)); 
     	SegmentList.add(new Parking(31,"parking 2", SegmentList.get(3).getId(), controlVehicles)); 
     	SegmentList.add(new Parking(32,"parking 3", SegmentList.get(7).getId(), controlVehicles)); 
     	SegmentList.add(new Parking(33,"parking 4", SegmentList.get(9).getId(), controlVehicles)); 
    }

}
