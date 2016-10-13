package com.liucheng.service;

import java.util.List;

import com.liucheng.bean.Order;
import com.liucheng.bean.OrderItems;
import com.liucheng.dao.OrderDao;

public class OrderService {
	OrderDao od=new OrderDao();
	public Boolean saveOrder(OrderItems orderItems,Integer customer_id,Integer address_id,Integer product_amount) {
		return od.saveOrder(orderItems,customer_id,address_id,product_amount);
	}
	
	public List<Order> getOrderByCustomerID(Integer customer_id){
		return od.getOrderByCustomerID(customer_id);
	}
}
