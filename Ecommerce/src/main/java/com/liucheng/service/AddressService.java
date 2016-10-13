package com.liucheng.service;

import java.util.List;

import com.liucheng.bean.Address;
import com.liucheng.dao.AddressDao;

public class AddressService {
	AddressDao ad=new AddressDao();
	public List<Address> getAddressByCustomerID(Integer customer_id){
		return ad.getAddressByCustomerID(customer_id);
	}
}
