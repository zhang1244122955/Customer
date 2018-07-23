package com.zz624.dao;

import java.util.List;
import java.util.Map;

import com.zz624.entry.Customer;
import com.zz624.entry.Goods;
import com.zz624.entry.Orders;
import com.zz624.entry.User;

//订单数据链路层
public interface OrdersDao {
	// 根据不同的客户经理(uid)登录查找对应的订单数据-分页后
	List<Orders> selectAllById(Map map);
	
	//根据不同的客户经理(uid)登录查找对应的订单数据-所有的
	List<Orders> selectAllOrders(int userid);
	
	//分页查询
	//List<Orders> selectOrderByCurr(Map map);

	
	// 根据查出的订单找出对应的客户信息
	Customer selectByCustid(int custid);

	// 查出的订单找出对应的商品信息+新增订单时需要的商品详情
	Goods selectByGid(int gid);
	
	//查找所有客户的名称
	List<Customer> selectAllCustName();
	
	//查找所有商品的名称
	List<Goods> selectAllGName();
	
	//增加订单
	int insertOrders(Orders orders);
	
	//判断权限
	int selectRoleidByUserid(int userid);
	int selectPowerByRoleid(int roleid);
	
	//修改订单 
	int updateOrders(Orders orders);
	
	//根据oid查找订单
	Orders selectByOid(int oid);
	
	//提交订单
	int updateOrdersSubmit(Orders orders);
	
	//审核订单(不分页)
	List<Orders> selectIsStatus();
	
	//审核订单(分页)
	List<Orders> selectIsStatusCurr(Map map);
	
	//根据userid查找username
	User selectByUserid(int userid);
	
	//修改审核状态和意见
	int updateSubmitAndRemarks(Orders orders);
	
	//显示处理订单(未分页)
	List<Orders> selectOrdersToDeal(int userid);
	
	//显示处理订单(分页)
	List<Orders> selectOrdersToDealCurr(Map map);
	
	//当订单审核不通过时修改订单报价
	int updateOrderOoffer(Orders orders);
	
	//修改订单报价后进行订单审核状态的修改
	int updateOrderOofferCheck(int oid);
	
	//订单归档(未分页)
	List<Orders> selectAllFinshOrders();
	
	//订单归档(分页)
	List<Orders> selectAllFinshOrdersCurr(Map map);
	
	//查询销售主管的所有的userid
	List<Integer> selectAllSale();
	
	//通过客户名去模糊查找客户id
	List<Integer> selectCustidByCustname(String custname);
	
	/*//从订单表中查找出所有的客户公司名称--统计分析
	List<String> selectAllCustnameAna();*/
}
