package com.liucheng.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.liucheng.bean.Customer;
import com.liucheng.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	CustomerService cs = new CustomerService();

	@RequestMapping("/customerList")
	public String getCustomerList(HttpServletRequest request, HttpServletResponse response) {
		List<Customer> customerList = cs.getCustomerList();
		request.setAttribute("customerList", customerList);
		return "forward:/admin/customers.jsp";
	}

	@RequestMapping("/preModify")
	public String preModefyCustomer(@RequestParam("customer_id") Integer customer_id, HttpServletRequest request,
			HttpServletResponse response) {
		Customer c = cs.getCustomerByID(customer_id);
		request.setAttribute("c", c);
		return "forward:/admin/modifyCustomers.jsp";
	}

	@RequestMapping("/deleteCustomer")
	public String deleteCustomer(@RequestParam("customer_id") Integer customer_id) {
		if (cs.deleteCustomer(customer_id))
			return "redirect:/customer/customerList.do";
		return "redirect:/error.jsp";
	}

	@RequestMapping("/modifyCustomer")
	public String modefyCustomer(@RequestParam("customer_id") Integer customer_id,
			@RequestParam("customer_name") String customer_name,
			@RequestParam("customer_password") String customer_password,
			@RequestParam("customer_sex") Integer customer_sex, @RequestParam("customer_phone") String customer_phone) {
		Customer c = new Customer();
		c.setCustomer_name(customer_name);
		c.setCustomer_password(customer_password);
		c.setCustomer_phone(customer_phone);
		c.setCustomer_sex(customer_sex);
		if (cs.modifyCustomer(c, customer_id))
			return "redirect:/customer/customerList.do";
		return "redirect:/customer/preModify.do?customer_id=" + customer_id;
	}

	@RequestMapping("/saveCustomer")
	public String saveCustomer(@RequestParam("customer_name") String customer_name,
			@RequestParam("customer_password") String customer_password,
			@RequestParam("customer_sex") Integer customer_sex, @RequestParam("customer_phone") String customer_phone,
			HttpServletResponse response, HttpServletRequest request) throws Exception, Exception {
		Customer c = new Customer();
		c.setCustomer_name(customer_name);
		c.setCustomer_password(customer_password);
		c.setCustomer_phone(customer_phone);
		c.setCustomer_sex(customer_sex);
		if (cs.saveCustomer(c)) {
			request.getSession().setAttribute("customer_name", customer_name);
		} else {
			return "redirect:/error.jsp";
		}
		return "redirect:/index.jsp";
	}

	@RequestMapping("/logout")
	public String logout(HttpServletRequest request) {
		request.getSession().invalidate();
		return "redirect:/index.jsp";
	}

	@RequestMapping("/login")
	public String login(@RequestParam("customer_name") String customer_name,
			@RequestParam("customer_password") String customer_password, HttpServletRequest request) throws Exception {
		if (cs.getCustomerByNameAndPwd(customer_name, customer_password)) {
			request.getSession().setAttribute("customer_name", customer_name);
			return "redirect:/index.jsp";
		}
		return "redirect:/error.jsp";
	}
}
