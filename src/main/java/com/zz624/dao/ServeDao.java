package com.zz624.dao;

import java.util.List;
import java.util.Map;

import com.zz624.entry.Contact;
import com.zz624.entry.Customer;
import com.zz624.entry.Serve;
import com.zz624.entry.User;

public interface ServeDao {
	
	//分页查询
	List<Serve> selectAllServe(Map map);
	
	
	//根据serveid查询单个服务
	Serve selectServe(int serveid);
	
	
	//根据客户编号查询客户名称
	String selectCusName(int custid);
	
	//查询所有客户信息
	List<Customer> selectAllCus();
	
	//查询所有客户id和联系人电话
	List<Contact> selectConPh();
	
	//添加服务
	int insertServe(Serve serve); 
	
	//修改服务的指派人处理人
	int updateServe(Serve serve);
	
	//修改服务的处理时间
	int updateSerdealtime(Serve serve);
	
	//修改服务满意度
	int updateSersatisfy(Serve serve);
	
	//修改服务的归档时间
	int updateSerkeeptime(String serkeeptime);
	
	//查询客户经理的角色id
	int selectCusManRoleId(String rolename);
	//查询所有客户经理
	List<User> selectAllCusManager(int roleid);
}
