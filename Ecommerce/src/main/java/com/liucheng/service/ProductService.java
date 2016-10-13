package com.liucheng.service;

import java.util.List;

import com.liucheng.bean.Product;
import com.liucheng.dao.ProductDao;

public class ProductService {
	ProductDao pd=new ProductDao();
	public List<Product> getCustomerList() {
		return pd.getProductList();
	}
	
	public Product getProductListByID(Integer product_id) {
		return pd.getProductListByID(product_id);
	}
	
	public List<Product> getProductListByIDs(Integer product_id) {
		return pd.getProductListByIDs(product_id);
	}
}
