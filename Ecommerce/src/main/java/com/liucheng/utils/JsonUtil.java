package com.liucheng.utils;

import java.util.List;

import net.sf.json.JSONArray;

public class JsonUtil<T> {
	
	public String arrayListToJson(List<T> l){
		JSONArray jsonArray =JSONArray.fromObject(l);
		return jsonArray.toString();
	}
}
