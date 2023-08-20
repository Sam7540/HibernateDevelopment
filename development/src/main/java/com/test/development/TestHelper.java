package com.test.development;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class TestHelper {
	@Id
	private int helperId;
	
	private String helperName;

	public TestHelper() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TestHelper(int helperId, String helperName) {
		super();
		this.helperId = helperId;
		this.helperName = helperName;
	}

	public int getHelperId() {
		return helperId;
	}

	public void setHelperId(int helperId) {
		this.helperId = helperId;
	}

	public String getHelperName() {
		return helperName;
	}

	public void setHelperName(String helperName) {
		this.helperName = helperName;
	}

}
