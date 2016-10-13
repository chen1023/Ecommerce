package com.liucheng.controller;

import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.liucheng.bean.OrderItems;
import com.liucheng.service.AddressService;
import com.liucheng.service.OrderService;
import com.liucheng.service.ProductService;
import com.liucheng.utils.UUIDUtil;

@Controller
@RequestMapping("/order")
public class OrderController {
	AddressService as=new AddressService();
	ProductService ps=new ProductService();
	OrderService os=new OrderService();
	@RequestMapping("/addOrder")
	public String addOrder(@RequestParam("product_id")Integer product_id,
			@RequestParam("customer_id")Integer customer_id,HttpServletRequest request,
			@RequestParam("product_number")Integer product_number){
		request.setAttribute("addressList", as.getAddressByCustomerID(customer_id));
		request.setAttribute("productList", ps.getProductListByIDs(product_id));
		request.setAttribute("product_number", product_number);
		return "forward:/customer/orders.jsp";
	}
	@RequestMapping("/saveOrder")
	public String saveOrder(@RequestParam("product_id")Integer product_id,
			@RequestParam("product_number")Integer product_number,
			@RequestParam("address_id")Integer address_id,
			@RequestParam("customer_id")Integer customer_id,@RequestParam("product_amount")Integer product_amount){
		OrderItems oi=new OrderItems();
		oi.setProduct_id(product_id);
		oi.setProduct_number(product_number);
		oi.setOrder_id(UUIDUtil.returnStr(UUID.randomUUID()));
		if(os.saveOrder(oi,customer_id,address_id,product_amount)){
			return "redirect:/order/getOrder.do?customer_id="+customer_id;
		}
		return "forward:/error.jsp";
	}
	
	@RequestMapping("/getOrder")
	public String getOrderByCustomerID(@RequestParam("customer_id")Integer customer_id,HttpServletRequest request){
		request.setAttribute("orderList", os.getOrderByCustomerID(customer_id));
		return "forward:/customer/ordersManager.jsp";
	}
}
