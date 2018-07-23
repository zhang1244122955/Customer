package com.zz624.biz;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.zz624.entry.Contact;
import com.zz624.entry.Customer;
import com.zz624.entry.Serve;
import com.zz624.entry.User;
import com.zz624.util.PageBean;

public interface ServeBiz {

	//查询数据库中所有服务
	List<Serve> findAllServe(String insearch);
	//查看所有服务
	List<Serve> findAllServe(Integer currentPage,String insearch);
	//根据服务id查询服务
	Serve findServe(int serveid);
	//根据创建人查询服务或处理人查询服务
	List<Serve> findServeByCreateOrDeal(String insearch,Integer currentPage,Integer sercreateid,Integer serdealid);
	//根据创建人查询服务或处理人查询服务
	List<Serve> findServeByCreateOrDeal(String insearch,Integer sercreateid,Integer serdealid);
	//根据处理人查询服务
	List<Serve> findServeByDeal(String insearch,Integer serdealid);
	//根据处理人查询服务
	List<Serve> findServeByDeal(String insearch,Integer currentPage,Integer serdealid);
	//根据客户编号查询客户名称
	String findCusName(int custid);
	//查询所有客户id和联系人电话
	List<Contact> selectConPh();
	//查询所有客户经理
	List<User> findAllCusManager();
	//查询所有客户信息
	List<Customer> findAllCus();
	//创建服务
	boolean addServe(Serve serve);
	//修改服务服务的指派人处理人
	boolean modifyServe(Serve serve);
	//修改服务的处理时间
	boolean modifySerdealtime(Serve serve);
	//修改服务满意度
	boolean modifySersatisfy(Serve serve);
	//修改服务的归档时间
	boolean modifySerkeeptime(String serkeeptime);
	
}
