package com.zz624.biz;

import java.util.List;
import java.util.Map;

import com.zz624.entry.Customer;
import com.zz624.entry.Goods;
import com.zz624.entry.Orders;
import com.zz624.entry.User;

//订单业务逻辑层
public interface OrdersBiz {
	// 根据不同的客户经理(uid)登录查找对应的订单数据
	List<Orders> findAllByid(int userid);
	List<Orders> findAllByid(Map map);

	// 根据查出的订单找出对应的客户信息
	Customer findAllByCustid(int custid);

	// 查出的订单找出对应的商品信息
	Goods findAllByGid(int gid);
	
	//查找出所有客户的名称
	List<Customer> AllCustName();
	
	//查找出所有商品的名称
	List<Goods> AllGName();

	//增加订单
	int addOrders(Orders orders);
	
	//修改订单
	int editOrders(Orders orders);
	
	//查找单个订单
	Orders findOrdersByOid(int oid);
	
	//提交订单
	int editordersSubmit(Orders orders);
	
	//审核订单(未分页)
	List<Orders> findAllStatus();
	
	//审核订单(分页)
	List<Orders> findAllStatusCurr(Map map);
	
	
	//查找用户姓名
	User findUser(int userid);
	
	//修改审核状态和备注
	int editOstatusAndRemarks(Orders orders);
	
	//显示需处理订单
	List<Orders> findAllDealOrders(int userid);
	List<Orders> findAllDealOrdersCurr(Map map);
	
	//修改订单报价
	int editOrdersOoffer(Orders orders);
	
	//修改订单报价后进行订单审核状态的修改
	int editOrderOofferCheck(int oid);
	
	//订单归档(未分页)
	List<Orders> findAllFinshOrders();
	
	//订单归档(分页)
	List<Orders> findAllFinshOrdersCurr(Map map);
	
	//查询所有销售主管的userid
	List<Integer> findAllSaleUserid();
	
	//通过客户名查询客户编号
	List<Integer> findCustidByCustname(String custname);
	
}
