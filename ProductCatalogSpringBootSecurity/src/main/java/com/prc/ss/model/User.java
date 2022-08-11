package com.prc.ss.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "usr_tbl")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int usrid;
	private String name;
	private String usrname;
	private String usermail;
	private String password;
//	@ManyToOne(fetch = FetchType.LAZY, optional = false)
//    @JoinColumn(name = "prdt_id", nullable = false)
//	private Product product;
	public User() {
		// TODO Auto-generated constructor stub
	}
	public int getUsrid() {
		return usrid;
	}
	public void setUsrid(int usrid) {
		this.usrid = usrid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUsrname() {
		return usrname;
	}
	public void setUsrname(String usrname) {
		this.usrname = usrname;
	}
	public String getUsermail() {
		return usermail;
	}
	public void setUsermail(String usermail) {
		this.usermail = usermail;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public User(int usrid, String name, String usrname, String usermail, String password) {
		super();
		this.usrid = usrid;
		this.name = name;
		this.usrname = usrname;
		this.usermail = usermail;
		this.password = password;
	}
	
}
