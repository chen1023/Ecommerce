package com.liucheng.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.liucheng.bean.ClassItems;
import com.liucheng.bean.IndexList;

public class IndexDao {
	Connection conn = null;
	PreparedStatement ps = null;
	PreparedStatement psItems = null;
	ResultSet rs = null;
	ResultSet rsItems = null;

	public List<IndexList> getAllClassList() {
		List<IndexList> indexLists = new ArrayList<IndexList>(); // 列表类型命名需加s
		List<ClassItems> itemLists=new ArrayList<ClassItems>();
		conn = ConnectionManager.getConnection();
		String sql = "select * from product_class";
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				IndexList indexList = new IndexList();
				indexList.setClass_name(rs.getString("class_name"));
				Integer class_id=rs.getInt("class_id");
				indexList.setClass_id(class_id);
				String sqlItems="SELECT items_id,item_name FROM class_items where class_id=?";
				psItems = conn.prepareStatement(sqlItems);
				psItems.setInt(1, class_id);
				rsItems=psItems.executeQuery();
				while(rsItems.next()){
					ClassItems classItems=new ClassItems();
					classItems.setItems_id(rsItems.getInt("items_id"));
					classItems.setItem_name(rsItems.getString("item_name"));
					itemLists.add(classItems);
				}
				indexList.setClass_items(itemLists);
				itemLists=new ArrayList<ClassItems>();
				indexLists.add(indexList);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionManager.closeAll(conn, ps, rs);
		}
		return indexLists;
	}
}
