package com.liucheng.service;

import java.util.List;

import com.liucheng.bean.IndexList;
import com.liucheng.dao.IndexDao;
import com.liucheng.utils.JsonUtil;

public class IndexService {
	IndexDao listDao=new IndexDao();
	
	public String getClassList(){
		List<IndexList> indexLists=listDao.getAllClassList();
		JsonUtil<IndexList> jsonUtil=new JsonUtil<IndexList>();
		String listJson=jsonUtil.arrayListToJson(indexLists);
		return listJson;
	}
}
