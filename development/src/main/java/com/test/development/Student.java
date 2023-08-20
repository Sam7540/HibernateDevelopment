package com.test.development;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String name;
	
	private String course;
	
	private int duration_in_months;
	
	private String city;
	

	public Student() {
		super();
	}

	public Student(String name, String course, int duration_in_months, String city) {
		super();
		this.name = name;
		this.course = course;
		this.duration_in_months = duration_in_months;
		this.city = city;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public int getDuration_in_months() {
		return duration_in_months;
	}

	public void setDuration_in_months(int duration_in_months) {
		this.duration_in_months = duration_in_months;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return "ID: "+id+", name: "+name+", course: "+course+", duration: "+duration_in_months+", city: "+city;
	}
	
	
}
