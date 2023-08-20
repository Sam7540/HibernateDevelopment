package com.test.development;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

@Entity
public class Employee {
	@Id
	private int empid;
	
	private String empName;
	
	private String city; 	
	
//	@OneToMany(mappedBy = "manager")
//	private List<Trainee> trainees;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "empProjects", 
				joinColumns = { @JoinColumn(name = "employeeId") },
				inverseJoinColumns = { @JoinColumn(name = "projectId") }
			)
	private List<Project> projects;

	public Employee(int empid, String empName, String city, List<Project> projects) {
	super();
	this.empid = empid;
	this.empName = empName;
	this.city = city;
	this.projects = projects;
}

	public Employee() {
		super();
	}

	public int getEmpid() {
		return empid;
	}

	public void setEmpid(int empid) {
		this.empid = empid;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
	
//	public List<Trainee> getTrainees() {
//		return trainees;
//	}
//
//	public void setTrainees(List<Trainee> trainees) {
//		this.trainees = trainees;
//	}

	public List<Project> getProjects() {
		return projects;
	}

	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}

	@Override
	public String toString() {
		return empid+" : "+empName+" : "+city;
	}
	
}
