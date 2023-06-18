package com.test.development;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Employee {
	@Id
	private int empid;
	
	private String empName;
	
	private String city; 	

	public Employee(int empid, String empName, String city) {
		super();
		this.empid = empid;
		this.empName = empName;
		this.city = city;
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
	
	@Override
	public String toString() {
		return empid+" : "+empName+" : "+city;
	}
	
}
