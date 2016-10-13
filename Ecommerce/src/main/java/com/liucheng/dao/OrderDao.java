package com.liucheng.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.liucheng.bean.Order;
import com.liucheng.bean.OrderItems;

public class OrderDao extends BaseDao{
	public Boolean saveOrder_id(String order_id,Integer customer_id,Integer address_id,Integer order_amount) {
		Boolean flag=false;
		try (Connection conn = ConnectionManager.getConnection()) {
			String sql="insert into `order`(order_id,customer_id,address_id,order_time,order_amount,order_status) values(?,?,?,?,?,?)";
			ps = conn.prepareStatement(sql);
			ps.setString(1, order_id);
			ps.setInt(2, customer_id);
			ps.setInt(3, address_id);
			ps.setTimestamp(4, new Timestamp(System.currentTimeMillis()));
			ps.setInt(5, order_amount);
			ps.setInt(6, 0);
			if(ps.executeUpdate()>0){
				flag=true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}
	public Boolean saveOrder(List<Order> orderLists) {
		
		return null;
	}
	
	public Boolean saveOrder(OrderItems orderItems,Integer customer_id,Integer address_id,Integer order_amount) {
		Boolean flag=false;
		if(saveOrder_id(orderItems.getOrder_id(),customer_id,address_id,order_amount)){
			try (Connection conn = ConnectionManager.getConnection()) {
				String sql="insert into order_items(product_number,order_id,product_id) values(?,?,?)";
				ps = conn.prepareStatement(sql);
				ps.setInt(1, orderItems.getProduct_number());
				ps.setString(2, orderItems.getOrder_id());
				ps.setInt(3, orderItems.getProduct_id());
				if(ps.executeUpdate()>0){
					flag=true;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
			return flag;
		}
	
	public List<Order> getOrderByID(String order_id){
		List<Order> l=new ArrayList<Order>();
		try (Connection conn = ConnectionManager.getConnection()) {
			String sql="select * from order where order_id="+order_id;
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next()){
				Order o=new Order();
				o.setOrder_id(order_id);
				o.setAddress_id(rs.getInt("address_id"));
				o.setOrder_amount(rs.getInt("order_amount"));
				o.setOrder_status(rs.getInt("order_status"));
				o.setOrder_time(rs.getDate("order_time"));
				l.add(o);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return l;
	}
	
	public List<Order> getOrderByCustomerID(Integer customer_id){
		List<Order> l=new ArrayList<Order>();
		try (Connection conn = ConnectionManager.getConnection()) {
			String sql="select * from `order` where customer_id="+customer_id;
			System.out.println(sql);
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next()){
				Order o=new Order();
				o.setOrder_id(rs.getString("order_id"));
				o.setOi(getOrderItemsByID(o.getOrder_id()));
				o.setAddress_id(rs.getInt("address_id"));
				o.setOrder_amount(rs.getInt("order_amount"));
				o.setOrder_status(rs.getInt("order_status"));
				o.setOrder_time(rs.getDate("order_time"));
				l.add(o);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return l;
	}
	
	public OrderItems getOrderItemsByID(String order_id){
		OrderItems oi=null;
		try (Connection conn = ConnectionManager.getConnection()) {
				String sql="select * from order_items where order_id="+"'"+order_id+"'";
				System.out.println(sql);
				PreparedStatement ps=conn.prepareStatement(sql);
				ResultSet rs=ps.executeQuery();
				while(rs.next()){
					oi=new OrderItems();
					oi.setProduct_id(rs.getInt("product_id"));
					oi.setProduct_number(rs.getInt("product_number"));
					//oi.setOrder_id(rs.getString("order_id"));
				}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return oi;
	}
}
