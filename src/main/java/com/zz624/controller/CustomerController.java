package com.zz624.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.zz624.biz.CustomerBiz;
import com.zz624.entry.Customer;
import com.zz624.entry.Orders;
import com.zz624.entry.Role;
import com.zz624.entry.User;
import com.zz624.entry.Wastage;
import com.zz624.util.ProducerService;

@Controller
public class CustomerController {
	@Autowired
	private CustomerBiz cb;

	@RequestMapping("/findCustomer")
	public String findCustomer(@RequestParam(defaultValue = "1") int currentpage, HttpServletRequest request) {
		System.out.println("---查询客户信息");
		// 查询所有没有添加的开发成功的预备客户名字
		List<String> list1 = cb.findCustname();
		request.setAttribute("list1", list1);
		List<Customer> list = cb.findCustomerByPage(currentpage);
		request.setAttribute("list", list);
		request.setAttribute("currentpage", currentpage);
		request.setAttribute("count", cb.findCustomer());
		return "forward:/customer-selectall.jsp?" + System.currentTimeMillis();
	}

	@RequestMapping("/fdmanagers")
	public String fdmanagers(HttpServletRequest request) {
		// 查询所有没有添加的开发成功的预备客户名字
		List<String> list1 = cb.findCustname();
		request.setAttribute("list1", list1);
		List<User> list = cb.findallmanager();
		request.setAttribute("list", list);
		return "customer-add";

	}

	@RequestMapping("/addCustomer")
	public String addCustomer(Customer customer, HttpServletRequest request) {
		System.out.println("---增加客户信息");

		cb.addCustomer(customer);
		return "redirect:/findCustomer";

	}

	@RequestMapping("/removeCustomer")
	public String removeCustomer(int custid, HttpServletRequest request) {
		System.out.println("---删除客户信息");
		cb.removeCustomer(custid);
		return "redirect:/findCustomer";
	}

	@RequestMapping("/modifyInfo")
	public String modifyInfo(int custid, HttpServletRequest request) {
		Customer customer = cb.findCustomers(custid);
		request.setAttribute("customer", customer);
		List<User> list = cb.findallmanager();
		request.setAttribute("list", list);
		return "customer-modify";
	}

	@RequestMapping("/modifyCustomer")
	public String modifyCustomer(Customer customer, HttpServletRequest request) {
		System.out.println("---修改客户信息");
		cb.modifyCustomer(customer);
		return "redirect:/findCustomer";
	}

	@RequestMapping("/orderInfo")
	public String orderInfo(int custid, HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.setAttribute("custid", custid);
		return "redirect:/historyorder";
	}

	@RequestMapping("/historyorder")
	public String historyorder(@RequestParam(defaultValue = "1") int currentpage, HttpServletRequest request) {
		HttpSession session = request.getSession();
		int custid = (int) session.getAttribute("custid");
		System.out.println((int) session.getAttribute("custid"));
		List<Orders> list = cb.findOrderByCustid(custid, currentpage);
		request.setAttribute("list", list);
		request.setAttribute("currentpage", currentpage);
		request.setAttribute("count", cb.findOrder());
		return "historyorder";
	}

	@Scheduled(cron = "0 01 12  * * ? ")
	@RequestMapping("/customerWastage")
	public void customerWastage() {
		int wastage = cb.findCustomerByOrderByWastage();
		List<Customer> list = cb.findCustomerByOrderByWastageInfo();
		for (Customer customer : list) {
			if (wastage > 0 && customer.getCuststate() == null) {

				cb.modifycustomerstate(customer.getCustid());
			}
		}

	}

	@RequestMapping("/customerWastagepage")
	public String customerWastagepage(@RequestParam(defaultValue = "1") int currentpage, HttpServletRequest request) {
		// 获取登录人的信息
		HttpSession session = request.getSession();
		Role role = (Role) session.getAttribute("role");
		User user = (User) session.getAttribute("user");
		List<Customer> list = cb.findCustomerByOrderByWastageInfo();
		if (list != null) {
			// 创建新的指派人后通知指派人
			ProducerService ps = new ProducerService();
			ps.sendMessage(user.getUserid().toString(), "您有待处理的客户流失信息");
			List<Wastage> list1 = new ArrayList<>();
			for (Customer customer : list) {
				Wastage W1 = cb.findwastagepage(customer.getCustid(), currentpage);
				list1.add(W1);
			}
			request.setAttribute("list1", list1);
			request.setAttribute("currentpage", currentpage);
			request.setAttribute("count", cb.findCustomerByOrderByWastage());
			return "custwastage";
		}
		return "custwastage";
	}
	@RequestMapping("/customerWastagepage1")
	public String customerWastagepage1(@RequestParam(defaultValue = "1") int currentpage, HttpServletRequest request) {
		// 获取登录人的信息
		HttpSession session = request.getSession();
		Role role = (Role) session.getAttribute("role");
		User user = (User) session.getAttribute("user");
		List<Customer> list = cb.findCustomerByOrderByWastageInfo();
		
			List<Wastage> list1 = new ArrayList<>();
			for (Customer customer : list) {
				Wastage W1 = cb.findwastagepage(customer.getCustid(), currentpage);
				list1.add(W1);}
			
			request.setAttribute("list1", list1);
			request.setAttribute("currentpage", currentpage);
			request.setAttribute("count", cb.findCustomerByOrderByWastage());
			return "custwastage";
		
	}
	@RequestMapping("/stopwastage")
	public String stopwastage(String custid, String stopwastageinfo, String stopwastageinfo1) {
		List<Customer> list = cb.findCustomerByOrderByWastageInfo();

		for (Customer customer : list) {
			if (customer.getCuststate().equals("暂缓流失")) {
				cb.modifystopwastage(custid, customer.getStopwastageinfo() + stopwastageinfo1);
			} else {
				cb.modifystopwastage(custid, stopwastageinfo);
			}

		}

		return "redirect:/customerWastagepage1";
	}

	@RequestMapping("/stopwastageinfo")
	public String stopwastageinfo(HttpServletRequest request, int custid) {

		Wastage w1 = cb.findwastage(custid);
		System.out.println(w1.getCustid());
		request.setAttribute("w1", w1);
		return "stopwastage";
	}

	@RequestMapping("/dmwastageinfo")
	public String dmwastageinfo(HttpServletRequest request, int custid) {

		Wastage w1 = cb.findwastage(custid);
		System.out.println(w1.getCustid());
		request.setAttribute("w1", w1);
		return "determinewastage";
	}

	@RequestMapping("/dmwastage")
	public String dmwastage(String custid, String determinestageinfo) {
		cb.modifydmwastage(custid, determinestageinfo);
		return "redirect:/customerWastagepage1";
	}
}
