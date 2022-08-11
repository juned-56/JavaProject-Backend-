package com.prc.ss.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "prdt_tbl")
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int prid;
	private String prcode;
	private String brand;
	private String prname;
	private String prdescription;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "pincode", nullable = false, foreignKey = @ForeignKey(name = "pincode"))
	Address address;
	
	
//	@OneToMany(targetEntity = Address.class, cascade = CascadeType.ALL)
//	@JoinColumn(name = "pincode", referencedColumnName = "id")
//	private List<Address> address;
	
//	@ManyToOne(fetch = FetchType.LAZY, optional = false)
//	@JoinColumn(name = "pr_pincode", nullable = false)
//	@JsonIgnore
//	private Address address;
	private long prprice;
//	private String prpincode;
//	@OneToMany(mappedBy = "product", fetch = FetchType.LAZY,
//            cascade = CascadeType.ALL)
//	private Set<User> user;


	public int getPrid() {
		return prid;
	}


	public Product(int prid, String prcode, String brand, String prname, String prdescription, Address address,
		long prprice) {
	super();
	this.prid = prid;
	this.prcode = prcode;
	this.brand = brand;
	this.prname = prname;
	this.prdescription = prdescription;
	this.address = address;
	this.prprice = prprice;
}


	public Address getAddress() {
		return address;
	}


	public void setAddress(Address address) {
		this.address = address;
	}


	public void setPrid(int prid) {
		this.prid = prid;
	}


	public String getPrcode() {
		return prcode;
	}


	public void setPrcode(String prcode) {
		this.prcode = prcode;
	}


	public String getBrand() {
		return brand;
	}


	public void setBrand(String brand) {
		this.brand = brand;
	}


	public String getPrname() {
		return prname;
	}


	public void setPrname(String prname) {
		this.prname = prname;
	}


	public String getPrdescription() {
		return prdescription;
	}


	public void setPrdescription(String prdescription) {
		this.prdescription = prdescription;
	}


	public long getPrprice() {
		return prprice;
	}


	public void setPrprice(long prprice) {
		this.prprice = prprice;
	}
	
}
