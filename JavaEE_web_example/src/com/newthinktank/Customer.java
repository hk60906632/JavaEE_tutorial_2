package com.newthinktank;

import java.io.Serializable;

public class Customer implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String fName;
	private String lName;
	private String phone;
	
	public Customer() {
		this.fName = "";
		this.lName = "";
		this.phone = "";
	}
	
	public Customer(String fName, String lName, String phone) {
		this.fName = fName;
		this.lName = lName;
		this.phone = phone;
	}
	
	public String getfName() {
		return fName;
	}
	public void setfName(String fName) {
		this.fName = fName;
	}
	public String getlName() {
		return lName;
	}
	public void setlName(String lName) {
		this.lName = lName;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	
}
