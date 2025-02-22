package com.servlet.ProductManagement;

import java.io.Serializable;

@SuppressWarnings("serial")
public class ProductBean implements Serializable {

	private int pcode;
	private String pname;
	private float pprice;
	private int pqty;
	public ProductBean() 
	{

	}
	public int getPcode() {
		return pcode;
	}
	public String getPname() {
		return pname;
	}
	public float getPprice() {
		return pprice;
	}
	public int getPqty() {
		return pqty;
	}
	public void setPcode(int pcode) {
		this.pcode = pcode;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public void setPprice(float pprice) {
		this.pprice = pprice;
	}
	public void setPqty(int pqty) {
		this.pqty = pqty;
	}
	
	}
