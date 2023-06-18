package com.test.development;

import java.util.Date;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.persistence.Transient;

@Entity
@Table(name="Employee_Address")
public class Address {
	
//	@GeneratedValue(strategy = GenerationType.UUID)
//	@UuidGenerator(style = Style.AUTO)
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int address_id;
	
	@Column(name = "STREET", length = 50)
	private String street;
	
	@Column(name = "CITY", length = 50)
	private String city;
	
	@Temporal(value = TemporalType.DATE)
	private Date dateCreated;
	
	@Column(name = "Image", columnDefinition = "LONGBLOB")
	private byte[] profileImage;
	
	@Transient
	private boolean isCurrentAddress;

	public Address(int address_id, String street, String city, Date dateCreated, byte[] profileImage, boolean isCurrentAddress) {
		super();
		this.address_id = address_id;
		this.street = street;
		this.city = city;
		this.dateCreated = dateCreated;
		this.profileImage = profileImage;
		this.isCurrentAddress = isCurrentAddress;
	}

	public Address() {
		super();
	}

	public int getAddress_id() {
		return address_id;
	}

	public void setAddress_id(int address_id) {
		this.address_id = address_id;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public boolean isCurrentAddress() {
		return isCurrentAddress;
	}

	public void setCurrentAddress(boolean isCurrentAddress) {
		this.isCurrentAddress = isCurrentAddress;
	}

	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	public byte[] getProfileImage() {
		return profileImage;
	}

	public void setProfileImage(byte[] profileImage) {
		this.profileImage = profileImage;
	}
	
}
