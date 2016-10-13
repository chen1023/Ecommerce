package com.liucheng.bean;

public class Address {
	private Integer address_id;
	private String address_content;
	private Integer customer_id;
	private String address_people;
	private String address_phone;
	public String getAddress_people() {
		return address_people;
	}
	public void setAddress_people(String address_people) {
		this.address_people = address_people;
	}
	public String getAddress_phone() {
		return address_phone;
	}
	public void setAddress_phone(String address_phone) {
		this.address_phone = address_phone;
	}
	public Integer getAddress_id() {
		return address_id;
	}
	public void setAddress_id(Integer address_id) {
		this.address_id = address_id;
	}
	public String getAddress_content() {
		return address_content;
	}
	public void setAddress_content(String address_content) {
		this.address_content = address_content;
	}
	public Integer getCustomer_id() {
		return customer_id;
	}
	public void setCustomer_id(Integer customer_id) {
		this.customer_id = customer_id;
	}
}
