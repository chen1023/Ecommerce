package com.liucheng.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.liucheng.bean.Product;
import com.liucheng.service.ProductService;

@Controller
@RequestMapping("/product")
public class ProductController {
	ProductService ps=new ProductService();
	@RequestMapping("/productList")
	public String getProductList(HttpServletRequest request){
		request.setAttribute("productList", ps.getCustomerList());
		return "forward:/admin/productions.jsp";
	}
	
	@RequestMapping("/productDetail")
	public String getProductByID(HttpServletRequest request,@RequestParam("product_id")Integer product_id){
		Product p=ps.getProductListByID(product_id);
		if((p.getProduct_name())!=null){
			request.setAttribute("product", p);
			return "forward:/productDetail.jsp";
		}
		return "forward:/error.jsp";
	}
}
