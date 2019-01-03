package clases;

import java.util.concurrent.Semaphore;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import control.ControlVehicles;

@Entity
@Table(name = "Segment")
public abstract class Segment implements Runnable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private Integer id;
	
	@Column(name = "state")
	private String state;
	
	@Column(name = "nextSegment")
	public int nextSegment;
	
	@Column(name = "nextSegment2")
	public int nextSegment2;
	
	@Column(name = "correspondientLineId")
	public int correspondientLineId;
	
	@Column(name = "name")
	public String name;
	
	ControlVehicles controlVehicles;
	Semaphore sem;

	public Segment() {}
	
	public Segment(int id, ControlVehicles control) {
		this.id=id;
		this.controlVehicles=control;
		this.sem=new Semaphore(1);
		
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getState() {
		return state;
	}


	public void setState(String state) {
		this.state = state;
	}


	public abstract void run();
	public boolean takePermission(Vehicle vehicle) throws InterruptedException {
		if(sem.availablePermits()==0) return false;
		else {
			sem.acquire();
			if(this.getClass().equals(Line.class))Thread.sleep(2000);
			else if(this.getClass().equals(Workstation.class))Thread.sleep(3000);
			else Thread.sleep(2000);
		}
		return true;
	}


	public int getNextSegment() {
		return nextSegment;
	}


	public void setNextSegment(int nextSegment) {
		this.nextSegment = nextSegment;
	}


	public int getNextSegment2() {
		return nextSegment2;
	}


	public void setNextSegment2(int nextSegment2) {
		this.nextSegment2 = nextSegment2;
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


	public Integer getId() {
		return id;
	}


}
