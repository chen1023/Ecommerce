package com.liucheng.dao;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import com.liucheng.bean.Customer;

public class CustomerDao extends BaseDao{

	public List<Customer> getCustomerList() {
		List<Customer> list = new ArrayList<Customer>();
		try (Connection conn = ConnectionManager.getConnection()) {
			String sql = "select * from customer";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				Customer c = new Customer();
				c.setCustomer_id(rs.getInt("customer_id"));
				c.setCustomer_name(rs.getString("customer_name"));
				c.setCustomer_password(rs.getString("customer_password"));
				c.setCustomer_sex(rs.getInt("customer_sex"));
				c.setCustomer_phone(rs.getString("customer_phone"));
				list.add(c);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public Customer getCustomerByID(Integer customer_id) {
		Customer c = null;
		try (Connection conn = ConnectionManager.getConnection()) {
			String sql = "select * from customer where customer_id="+customer_id;
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				c = new Customer();
				c.setCustomer_id(rs.getInt("customer_id"));
				c.setCustomer_name(rs.getString("customer_name"));
				c.setCustomer_password(rs.getString("customer_password"));
				c.setCustomer_sex(rs.getInt("customer_sex"));
				c.setCustomer_phone(rs.getString("customer_phone"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return c;
	}
	
	public Boolean getCustomerByNameAndPwd(String customer_name,String customer_password) {
		try (Connection conn = ConnectionManager.getConnection()) {
			String sql = "select * from customer where customer_name='"+customer_name+"' and customer_password='"+customer_password+"'";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			if(rs.next()) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public Boolean modifyCustomer(Customer c,Integer customer_id) {
		Boolean flag=false;
		try (Connection conn = ConnectionManager.getConnection()) {
			String sql = "update customer set customer_name=?,customer_password=?,customer_sex=?,customer_phone=? where customer_id ="+customer_id;
			ps = conn.prepareStatement(sql);
			ps.setString(1, c.getCustomer_name());
			ps.setString(2, c.getCustomer_password());
			ps.setInt(3, c.getCustomer_sex());
			ps.setString(4, c.getCustomer_phone());
			if(ps.executeUpdate()>0){
				flag=true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
	
	public Boolean deleteCustomer(Integer customer_id) {
		return delete("delete from customer where customer_id ="+customer_id);
	}
	
	public Boolean saveCustomer(Customer c) {
		Boolean flag=false;
		try (Connection conn = ConnectionManager.getConnection()) {
			String sql = "insert into customer(customer_name,customer_password,customer_sex,customer_phone) values(?,?,?,?)";
			ps = conn.prepareStatement(sql);
			ps.setString(1, c.getCustomer_name());
			ps.setString(2, c.getCustomer_password());
			ps.setInt(3, c.getCustomer_sex());
			ps.setString(4, c.getCustomer_phone());
			if(ps.executeUpdate()>0){
				flag=true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
}
