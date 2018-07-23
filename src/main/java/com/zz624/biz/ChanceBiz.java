package com.zz624.biz;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.zz624.util.PageBean;
import com.zz624.entry.Chance;
import com.zz624.entry.User;

public interface ChanceBiz {
	// 销售主管查询所有销售机会
	int findAllChances();

	// 销售主管查询所有销售机会(分页)
	List<Chance> findAllChancesByPage(int page);

	// 客户经理查询所有销售机会
	int findallbyid(int createid);

	// 销售主管查询所有销售机会(分页)
	List<Chance> findAllChancesByIdByPage(int page, int createid);

	// 添加营销机会
	boolean addchance(Chance chance);

	// 修改销售机会的方法(未审核或待修改)
	boolean modifychance(Chance chance);

	// 客户经理在未审核之前删除销售机会
	boolean removechance(int chid);

	// 通过机会id查询次机会信息
	Chance findbychid(int chid);

	// 分页查所有
	PageBean selectpaging(int currentPage, int pageSize, HttpServletRequest request);

	// 查询所有客户经理
	List<User> findallmanager(String assigneedname);

	// 查询所有客户经理
	List<User> findallmanagerinfo();

	// 通过机会编号查询指派人姓名
	User findUserName(int chid);

	

}
