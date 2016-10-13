package com.liucheng.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 此类用于展示公共操作模板类
 * @author Administrator
 */
public class BaseDao{
	PreparedStatement ps = null;
	ResultSet rs = null;
	/**
	 * 删除操作公共类
	 * @param sql
	 * @return boolean
	 */
	public Boolean delete(String sql){
		System.out.println(sql);
		Boolean flag=false;
		try (Connection conn = ConnectionManager.getConnection()) {
			ps = conn.prepareStatement(sql);
			if(ps.executeUpdate()>0){
				flag=true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}
	
	/**
	 * 获取统计数据公共类
	 * @param sql
	 * @return Integer
	 */
	public Integer count(String sql){
		System.out.println(sql);
		Integer count=0;
		try (Connection conn = ConnectionManager.getConnection()) {
			ps = conn.prepareStatement(sql);
			count=ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}
}
