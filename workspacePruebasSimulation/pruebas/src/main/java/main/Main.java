package main;

import java.util.List;

import clases.Line;
import clases.Parking;
import clases.Segment;
import clases.Workspace;

public class Main {
	
	List<Segment> SegmentList;
	
	public Main() {
		inicializar();
		
	}
	
    public static void main(String[] args) throws Exception {

    	@SuppressWarnings("unused")
		Main main= new Main();
    	
    }
    
    public void inicializar() {
    	inicializarSegmentos();
    	
    }
    
    public void inicializarSegmentos() {
    	SegmentList.add(new Line(0, 1, 2));//-1 equivale a null
    	SegmentList.add(new Line(1, 3, -1));
    	SegmentList.add(new Line(2, 5, -1));
    	SegmentList.add(new Line(3, 4, -1));
    	SegmentList.add(new Line(4, 5, -1));
    	SegmentList.add(new Line(5, 6, -1));
    	SegmentList.add(new Line(6, 0, -1));
     	SegmentList.add(new Workspace(10, (Line) SegmentList.get(0)));
     	SegmentList.add(new Workspace(11, (Line) SegmentList.get(4)));
     	SegmentList.add(new Parking(20, (Line) SegmentList.get(1)));
    	
    }

}
