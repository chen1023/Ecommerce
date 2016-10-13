package com.liucheng.bean;

public class ClassItems {
	private Integer items_id;
	private String item_name;
	public ClassItems(Integer items_id, String item_name) {
		super();
		this.items_id = items_id;
		this.item_name = item_name;
	}
	public ClassItems() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Integer getItems_id() {
		return items_id;
	}
	public void setItems_id(Integer items_id) {
		this.items_id = items_id;
	}
	public String getItem_name() {
		return item_name;
	}
	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}
}
