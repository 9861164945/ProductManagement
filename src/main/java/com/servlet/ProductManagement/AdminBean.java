package com.servlet.ProductManagement;

import java.io.Serializable;

@SuppressWarnings("serial")
public class AdminBean implements Serializable
{
	private String uName,pword,fname,city,email;
	private long phNo;
	public String getuName() {
		return uName;
	}
	public String getPword() {
		return pword;
	}
	public String getFname() {
		return fname;
	}
	public String getCity() {
		return city;
	}
	public String getEmail() {
		return email;
	}
	public long getPhNo() {
		return phNo;
	}
	public void setuName(String uName) {
		this.uName = uName;
	}
	public void setPword(String pword) {
		this.pword = pword;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setPhNo(long phNo) {
		this.phNo = phNo;
	}
	
	

}
