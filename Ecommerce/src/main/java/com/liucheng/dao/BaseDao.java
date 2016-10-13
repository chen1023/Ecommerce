package com.liucheng.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * ��������չʾ��������ģ����
 * @author Administrator
 */
public class BaseDao{
	PreparedStatement ps = null;
	ResultSet rs = null;
	/**
	 * ɾ������������
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
	 * ��ȡͳ�����ݹ�����
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
