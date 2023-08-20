package com.test.development;

import java.util.Date;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Project {
	@Id
	private int projectId;
	
	private String projectName;
	
	private Date assignedDate;
	
	@ManyToMany(mappedBy = "projects")
	private List<Employee> employees;

	public Project() {
		super();
	}

	public Project(int projectId, String projectName, Date assignedDate, List<Employee> employees) {
		super();
		this.projectId = projectId;
		this.projectName = projectName;
		this.assignedDate = assignedDate;
		this.employees = employees;
	}

	public int getProjectId() {
		return projectId;
	}

	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public Date getAssignedDate() {
		return assignedDate;
	}

	public void setAssignedDate(Date assignedDate) {
		this.assignedDate = assignedDate;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

}
