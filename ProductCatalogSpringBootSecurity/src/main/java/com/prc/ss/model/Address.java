package com.prc.ss.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "adrs_tbl")
public class Address {
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	private int id;
	private String city;
	private String district;
	private String state;
	@Id
	private int pincode;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "address", cascade = CascadeType.ALL)
	private Set<Product> product;
	
public Set<Product> getProduct() {
		return product;
	}

	public void setProduct(Set<Product> product) {
		this.product = product;
	}

	//	@OneToMany(mappedBy = "address", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//	private Set<Product> product;
	public Address() {
		// TODO Auto-generated constructor stub
	}

//	public int getId() {
//		return id;
//	}
//
//	public void setId(int id) {
//		this.id = id;
//	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getPincode() {
		return pincode;
	}

	public void setPincode(int pincode) {
		this.pincode = pincode;
	}

	public Address(String city, String district, String state, int pincode, Set<Product> product) {
		super();
		this.city = city;
		this.district = district;
		this.state = state;
		this.pincode = pincode;
		this.product = product;
	}
	
	
}
