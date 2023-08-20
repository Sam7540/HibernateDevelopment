package com.test.development;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.OneToMany;

@Entity
public class Test {
	@Id
	private int id;
	
	private String name;
	
	private boolean isSuccessfull;
	
	private List<Integer> numbers;
	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
	@JoinTable(name = "helpingTable",
			joinColumns = { @JoinColumn(name = "TestId") },
			inverseJoinColumns = { @JoinColumn(name = "HelperId") }
			)
	private List<TestHelper> helpers;

	public Test() {
		super();
	}

	public Test(int id, String name, boolean isSuccessfull, List<Integer> numbers, List<TestHelper> helpers) {
		super();
		this.id = id;
		this.name = name;
		this.isSuccessfull = isSuccessfull;
		this.numbers = numbers;
		this.helpers = helpers;
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

	public boolean isSuccessfull() {
		return isSuccessfull;
	}

	public void setSuccessfull(boolean isSuccessfull) {
		this.isSuccessfull = isSuccessfull;
	}

	public List<Integer> getNumbers() {
		return numbers;
	}

	public void setNumbers(List<Integer> numbers) {
		this.numbers = numbers;
	}
	
	public List<TestHelper> getHelpers() {
		return helpers;
	}

	public void setHelpers(List<TestHelper> helpers) {
		this.helpers = helpers;
	}

	@Override
	public String toString() {
		return id+" "+name+" "+isSuccessfull+" "+numbers;
	}
}
