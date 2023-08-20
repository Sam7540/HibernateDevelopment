package com.test.development;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Trainee {
	
	@Id
	private int traineeId;
	
	private String traineeName;
	
	private String traineeDepartment;
	
	@ManyToOne
	@JoinColumn(name = "managerId")
	private Employee manager;

	public Trainee(int traineeId, String traineeName, String traineeDepartment, Employee manager) {
		super();
		this.traineeId = traineeId;
		this.traineeName = traineeName;
		this.traineeDepartment = traineeDepartment;
		this.manager = manager;
	}

	public Trainee() {
		super();
	}

	public int getTraineeId() {
		return traineeId;
	}

	public void setTraineeId(int traineeId) {
		this.traineeId = traineeId;
	}

	public String getTraineeName() {
		return traineeName;
	}

	public void setTraineeName(String traineeName) {
		this.traineeName = traineeName;
	}

	public String getTraineeDepartment() {
		return traineeDepartment;
	}

	public void setTraineeDepartment(String traineeDepartment) {
		this.traineeDepartment = traineeDepartment;
	}

	public Employee getManager() {
		return manager;
	}

	public void setManager(Employee manager) {
		this.manager = manager;
	}
	
}
