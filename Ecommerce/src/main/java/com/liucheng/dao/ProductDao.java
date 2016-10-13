package com.liucheng.dao;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import com.liucheng.bean.Product;

public class ProductDao extends BaseDao{
	public List<Product> getProductList() {
		List<Product> productList=new ArrayList<Product>();
		try (Connection conn = ConnectionManager.getConnection()) {
			String sql = "select * from product";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()){
				Product p=new Product();
				p.setProduct_id(rs.getInt("product_id"));
				p.setProduct_name(rs.getString("product_name"));
				p.setProduct_amount(rs.getInt("product_amount"));
				p.setProduct_profile(rs.getString("product_profile"));
				p.setProduct_number(rs.getInt("product_number"));
				p.setClass_id(rs.getInt("class_id"));
				p.setProduct_sales(rs.getInt("product_sales"));
				productList.add(p);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return productList;
	}
	
	public Product getProductListByID(Integer product_id) {
		Product p=new Product();
		try (Connection conn = ConnectionManager.getConnection()) {
			String sql = "select * from product where product_id="+product_id;
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			if(rs.next()){	
				p.setProduct_id(rs.getInt("product_id"));
				p.setProduct_name(rs.getString("product_name"));
				p.setProduct_amount(rs.getInt("product_amount"));
				p.setProduct_profile(rs.getString("product_profile"));
				p.setProduct_number(rs.getInt("product_number"));
				p.setClass_id(rs.getInt("class_id"));
				p.setProduct_sales(rs.getInt("product_sales"));
				p.setProduct_image(rs.getString("product_image"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return p;
	}
	
	public List<Product> getProductListByIDs(Integer product_id) {
		List<Product> l=new ArrayList<Product>();
		try (Connection conn = ConnectionManager.getConnection()) {
			String sql = "select * from product where product_id="+product_id;
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()){	
				Product p=new Product();
				p.setProduct_id(rs.getInt("product_id"));
				p.setProduct_name(rs.getString("product_name"));
				p.setProduct_amount(rs.getInt("product_amount"));
				p.setProduct_profile(rs.getString("product_profile"));
				p.setProduct_number(rs.getInt("product_number"));
				p.setClass_id(rs.getInt("class_id"));
				p.setProduct_sales(rs.getInt("product_sales"));
				p.setProduct_image(rs.getString("product_image"));
				l.add(p);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return l;
	}
	
	public List<Product> getProductListByClass(Integer class_id) {
		return null;
	}
	
	public List<Product> getProductListByKey(String key) {
		return null;
	}
}
