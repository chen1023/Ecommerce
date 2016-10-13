package com.liucheng.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.liucheng.bean.Address;

public class AddressDao extends BaseDao{
	public List<Address> getAddressByCustomerID(Integer customer_id){
		List<Address> addressLists=new ArrayList<Address>();
		try (Connection conn = ConnectionManager.getConnection()) {
			String sql = "select * from address where customer_id="+customer_id;
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()){
				Address a=new Address();
				a.setAddress_id(rs.getInt("address_id"));
				a.setAddress_content(rs.getString("address_content"));
				a.setCustomer_id(customer_id);
				a.setAddress_people(rs.getString("address_people"));
				a.setAddress_phone(rs.getString("address_phone"));
				addressLists.add(a);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return addressLists;
	}
}
