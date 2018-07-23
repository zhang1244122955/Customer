package com.zz624.biz;

import java.util.List;

import javax.swing.text.StyledEditorKit.BoldAction;

import com.zz624.entry.Customer;
import com.zz624.entry.Orders;
import com.zz624.entry.User;
import com.zz624.entry.Wastage;

public interface CustomerBiz {
	// 销售主管查询客户信息
	int findCustomer();

	// 销售主管查询客户信息（分页）
	List<Customer> findCustomerByPage(int currentpage);

	// 增加客户信息
	boolean addCustomer(Customer customer);

	// 删除客户信息
	boolean removeCustomer(int custid);

	// 修改客户信息
	boolean modifyCustomer(Customer customer);

	// 查询所有客户信息
	Customer findCustomers(int custid);

	// 查询所有客户经理
	List<User> findallmanager();

	// 查询所有没有添加的开发成功的预备客户名字
	List<String> findCustname();

	// 参看指定客户所有订单信息
	List<Orders> findOrderByCustid(int custid, int currentpage);

	// 查看所有订单信息
	int findOrder();

	// 查看客户流失订单
	int findCustomerByOrderByWastage();

	// 查看客户流失订单信息
	List<Customer> findCustomerByOrderByWastageInfo();

	// 流失订单分页
	List<Customer> findCustomerByOrderByWastage(int currentpage);

	// 查看预警流失的客户信息及这个客户最后一次提交的订单(分页)
	Wastage findwastagepage(Integer custid, int currentpage);

	// 查看预警流失的客户信息及这个客户最后一次提交的订单
	Wastage findwastage(Integer custid);

	// 流失预警时更改客户状态
	boolean modifycustomerstate(int custid);

	// 暂缓流失
	boolean modifystopwastage(String custid, String stopwastageinfo);
	//确认流失
	boolean modifydmwastage(String custid, String determinestageinfo);
}
