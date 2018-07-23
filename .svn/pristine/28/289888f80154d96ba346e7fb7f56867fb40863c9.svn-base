package com.zz624.biz.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zz624.biz.OrdersBiz;
import com.zz624.dao.OrdersDao;
import com.zz624.entry.Customer;
import com.zz624.entry.Goods;
import com.zz624.entry.Orders;
import com.zz624.entry.User;
@Service
public class OrdersBizImpl implements OrdersBiz {
	@Autowired
	private OrdersDao od;
	//根据不同的客户经理(uid)登录查找对应的订单数据
	@Override
	public List<Orders> findAllByid(Map map) {
		return od.selectAllById(map);
	}
	@Override
	public Customer findAllByCustid(int custid) {
		return od.selectByCustid(custid);
	}
	@Override
	public Goods findAllByGid(int gid) {
		return od.selectByGid(gid);
	}
	@Override
	public List<Customer> AllCustName() {
		return od.selectAllCustName();
	}
	@Override
	public List<Goods> AllGName() {
		return od.selectAllGName();
	}
	@Override
	public int addOrders(Orders orders) {
		return od.insertOrders(orders);
	}
	@Override
	public int editOrders(Orders orders) {
		return od.updateOrders(orders);
	}
	@Override
	public Orders findOrdersByOid(int oid) {
		return od.selectByOid(oid);
	}
	@Override
	public int editordersSubmit(Orders orders) {
		return od.updateOrdersSubmit(orders);
	}
	@Override
	public List<Orders> findAllStatus() {
		return od.selectIsStatus();
	}
	@Override
	public User findUser(int userid) {
		return od.selectByUserid(userid);
	}
	@Override
	public int editOstatusAndRemarks(Orders orders) {
		return od.updateSubmitAndRemarks(orders);
	}
	@Override
	public List<Orders> findAllDealOrders(int userid) {
		return od.selectOrdersToDeal(userid);
	}
	@Override
	public int editOrdersOoffer(Orders orders) {
		return od.updateOrderOoffer(orders);
	}
	@Override
	public int editOrderOofferCheck(int oid) {
		return od.updateOrderOofferCheck(oid);
	}
	@Override
	public List<Orders> findAllByid(int userid) {
		return od.selectAllOrders(userid);
	}
	@Override
	public List<Orders> findAllDealOrdersCurr(Map map) {
		return od.selectOrdersToDealCurr(map);
	}
	@Override
	public List<Orders> findAllStatusCurr(Map map) {
		return od.selectIsStatusCurr(map);
	}
	@Override
	public List<Orders> findAllFinshOrders() {
		return od.selectAllFinshOrders();
	}
	@Override
	public List<Orders> findAllFinshOrdersCurr(Map map) {
		return od.selectAllFinshOrdersCurr(map);
	}
	@Override
	public List<Integer> findAllSaleUserid() {
		return od.selectAllSale();
	}
	@Override
	public List<Integer> findCustidByCustname(String custname) {
		return od.selectCustidByCustname(custname);
	}
}
