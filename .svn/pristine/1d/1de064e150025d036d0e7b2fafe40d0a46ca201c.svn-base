package com.zz624.dao;

import java.util.List;
import java.util.Map;

import com.zz624.entry.Customer;
import com.zz624.entry.Orders;
import com.zz624.entry.User;
import com.zz624.entry.Wastage;

public interface CustomerDao {
	// 高管查询客户信息
	int selectCustomer();

	// 高管查询客户信息（分页）
	List<Customer> selectCustomerByPage(int page);

	// 增加客户信息
	int insertCustomer(Customer customer);

	// 删除客户信息
	int deleteCustomer(int custid);

	// 修改客户信息
	int updateCustomer(Customer customer);

	// 查询所有客户信息
	Customer selectCustomers(int custid);

	// 查询客户经理的方法
	List<User> selectManager();

	// 查询所有没有添加的开发成功的预备客户名字
	List<String> selectCustName();

	// 参看指定客户所有订单信息
	List<Orders> selectOrderByCustid(Map map);

	// 查询所有订单信息
	int selectOrder();

	// 查看客户流失订单
	int selectCustomerByOrderByWastage();

	// 查看客户流失订单信息
	List<Customer> selectCustomerByOrderByWastageInfo();

	// 流失订单分页
	List<Customer> selectCustomerByOrderByWastagepage(int page);

	// 查看预警流失的客户信息及这个客户最后一次提交的订单(分页)
	Wastage selectwastagepage(Map map);
	// 查看预警流失的客户信息及这个客户最后一次提交的订单
	Wastage selectwastage(int custid);
	// 流失预警时更改客户状态
	int updatecustomerstate(int custid);

	// 暂缓流失
	int updatestopwastage(Map map);
	//确认流失
	int updatedmwastage(Map map);

}
