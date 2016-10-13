package com.liucheng.service;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import com.liucheng.bean.Customer;
import com.liucheng.dao.CustomerDao;
import com.liucheng.utils.Config;
import com.liucheng.utils.MD5Util;

public class CustomerService {
	CustomerDao cd=new CustomerDao();
	public List<Customer> getCustomerList(){
		return cd.getCustomerList();
	}
	
	public Customer getCustomerByID(Integer customer_id) {
		return cd.getCustomerByID(customer_id);
	}
	
	public Boolean modifyCustomer(Customer c,Integer customer_id) {
		return cd.modifyCustomer(c, customer_id);
	}
	
	public Boolean deleteCustomer(Integer customer_id) {
		return cd.deleteCustomer(customer_id);
	}
	
	public Boolean saveCustomer(Customer c) throws UnsupportedEncodingException, NoSuchAlgorithmException {
		c.setCustomer_password(MD5Util.md5(c.getCustomer_password()+Config.SALT));
		return cd.saveCustomer(c);
	}
	
	public Boolean getCustomerByNameAndPwd(String customer_name,String customer_password) throws Exception, Exception {
		return cd.getCustomerByNameAndPwd(customer_name, MD5Util.md5(customer_password+Config.SALT));
	}
}
