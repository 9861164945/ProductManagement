package com.servlet.ProductManagement;

import java.io.Serializable;

@SuppressWarnings("serial")
public class ProductBean implements Serializable {

	private String code,name;
	private float price;
	private int qty;
	public ProductBean() 
	{

	}
	public String getCode() {
		return code;
	}
	public String getName() {
		return name;
	}
	public float getPrice() {
		return price;
	}
	public int getQty() {
		return qty;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	

}
