package com.liucheng.bean;

public class Product {
	private Integer product_id;
	private String product_name;
	private Integer product_amount;
	private String product_profile;
	private Integer product_number;
	private Integer class_id;
	private Integer product_sales;
	private String product_image;
	public Product(Integer product_id, String product_name, Integer product_amount, String product_profile,
			Integer product_number, Integer class_id, Integer product_sales) {
		super();
		this.product_id = product_id;
		this.product_name = product_name;
		this.product_amount = product_amount;
		this.product_profile = product_profile;
		this.product_number = product_number;
		this.class_id = class_id;
		this.product_sales = product_sales;
	}
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getProduct_image() {
		return product_image;
	}
	public void setProduct_image(String product_image) {
		this.product_image = product_image;
	}
	public Integer getProduct_id() {
		return product_id;
	}
	public void setProduct_id(Integer product_id) {
		this.product_id = product_id;
	}
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	public Integer getProduct_amount() {
		return product_amount;
	}
	public void setProduct_amount(Integer product_amount) {
		this.product_amount = product_amount;
	}
	public String getProduct_profile() {
		return product_profile;
	}
	public void setProduct_profile(String product_profile) {
		this.product_profile = product_profile;
	}
	public Integer getProduct_number() {
		return product_number;
	}
	public void setProduct_number(Integer product_number) {
		this.product_number = product_number;
	}
	public Integer getClass_id() {
		return class_id;
	}
	public void setClass_id(Integer class_id) {
		this.class_id = class_id;
	}
	public Integer getProduct_sales() {
		return product_sales;
	}
	public void setProduct_sales(Integer product_sales) {
		this.product_sales = product_sales;
	}
}
