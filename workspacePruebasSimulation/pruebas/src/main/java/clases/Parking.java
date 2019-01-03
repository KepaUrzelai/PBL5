package clases;

import javax.persistence.Column;

import control.ControlVehicles;

public class Parking extends Segment{
	
	@Column(name = "correspondientLineId")
	public int correspondientLineId;
	
	@Column(name = "name")
	public String name;
	
	public Parking() {}

	public Parking(int id,String name, int correspondient, ControlVehicles control) {
		super(id, control);
		// TODO Auto-generated constructor stub
		this.name=name;
		this.correspondientLineId=correspondient;
	}



	public int getCorrespondientLineId() {
		return correspondientLineId;
	}



	public void setCorrespondientLineId(int correspondientLineId) {
		this.correspondientLineId = correspondientLineId;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}

}
