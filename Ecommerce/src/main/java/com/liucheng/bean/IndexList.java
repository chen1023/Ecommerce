package com.liucheng.bean;

import java.util.List;

public class IndexList {
	private Integer class_id;
	private String class_name;
	private List<ClassItems> class_items;
	public IndexList(Integer class_id, String class_name, List<ClassItems> class_items) {
		super();
		this.class_id = class_id;
		this.class_name = class_name;
		this.class_items = class_items;
	}
	public IndexList() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Integer getClass_id() {
		return class_id;
	}
	public void setClass_id(Integer class_id) {
		this.class_id = class_id;
	}
	public String getClass_name() {
		return class_name;
	}
	public void setClass_name(String class_name) {
		this.class_name = class_name;
	}
	public List<ClassItems> getClass_items() {
		return class_items;
	}
	public void setClass_items(List<ClassItems> class_items) {
		this.class_items = class_items;
	}
	
}
