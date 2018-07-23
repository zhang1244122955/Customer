package com.zz624.biz.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.core.appender.mom.kafka.KafkaAppender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.zz624.biz.CustomerBiz;
import com.zz624.dao.CustomerDao;
import com.zz624.entry.Customer;
import com.zz624.entry.Orders;
import com.zz624.entry.User;
import com.zz624.entry.Wastage;

@Service
public class CustomerBizImpl implements CustomerBiz {
	@Autowired
	private CustomerDao cd;

	@Override
	public int findCustomer() {
		System.out.println("---查询客户信息");
		return cd.selectCustomer();
	}

	@Override
	public List<Customer> findCustomerByPage(int currentpage) {
		int page = (currentpage - 1) * 8;
		return cd.selectCustomerByPage(page);
	}

	@Override
	public boolean addCustomer(Customer customer) {
		System.out.println("---增加客户信息");
		int i = cd.insertCustomer(customer);
		if (i > 0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean removeCustomer(int custid) {
		System.out.println("---删除客户信息");
		int i = cd.deleteCustomer(custid);
		if (i > 0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean modifyCustomer(Customer customer) {
		System.out.println("---修改客户信息");
		int i = cd.updateCustomer(customer);
		if (i > 0) {
			return true;
		}
		return false;
	}

	@Override
	public Customer findCustomers(int custid) {
		System.out.println("---查询所有客户信息");
		return cd.selectCustomers(custid);
	}

	@Override
	public List<User> findallmanager() {
		List<User> list = cd.selectManager();
		if (list != null) {
			return list;
		}
		return null;
	}

	@Override
	public List<String> findCustname() {
		
		return cd.selectCustName();
	}

	@Override
	public List<Orders> findOrderByCustid(int custid,int currentpage) {
		int page=(currentpage-1)*8;
		Map<String, Integer> map=new HashMap();
		map.put("custid", custid);
		map.put("page", page);
		return cd.selectOrderByCustid(map);
	}

	@Override
	public int findOrder() {
		
		return cd.selectOrder();
	}
	
	
	@Override
	public int findCustomerByOrderByWastage() {
		return cd.selectCustomerByOrderByWastage();
	}

	@Override
	public List<Customer> findCustomerByOrderByWastage(int currentpage) {
		int page=(currentpage-1)*8;
		return cd.selectCustomerByOrderByWastagepage(page);
	}


	@Override
	public boolean modifycustomerstate(int custid) {
		int n=cd.updatecustomerstate(custid);
		if (n>0) {
			return true;
		}
		return false;
	}

	@Override
	public List<Customer> findCustomerByOrderByWastageInfo() {
		
		return cd.selectCustomerByOrderByWastageInfo();
	}

	@Override
	public Wastage findwastagepage(Integer custid, int currentpage) {
		int page=(currentpage-1)*8;
		Map<String,Integer> map = new HashMap<>();
		map.put("custid", custid);
		map.put("page", page);
		return cd.selectwastagepage(map);
	}

	@Override
	public boolean modifystopwastage(String custid, String stopwastageinfo) {
		Map<String, String> map= new HashMap<>();
		map.put("custid", custid);
		map.put("stopwastageinfo", stopwastageinfo);
		int n=cd.updatestopwastage(map);
		if (n>0) {
			return true;
		}
		return false;
	}

	@Override
	public Wastage findwastage(Integer custid) {
		
		return cd.selectwastage(custid);
	}

	@Override
	public boolean modifydmwastage(String custid, String determinestageinfo) {
		Map<String, String> map= new HashMap<>();
		map.put("custid", custid);
		map.put("determinestageinfo", determinestageinfo);
		int n=cd.updatedmwastage(map);
		if (n>0) {
			return true;
		}
		return false;
	}

}
