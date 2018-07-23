package com.zz624.dao;

import java.util.List;
import java.util.Map;

import com.zz624.entry.Chance;
import com.zz624.entry.User;

public interface ChanceDao {
	// 销售主管查询所有的营销机会
	int selectChance();

	// 销售主管查询所有的营销机会（分页）
	List<Chance> selectChanceByPage(int page);

	// 客户经理查询自己创建的营销机会
	int selectChanceById(int createid);

	// 客户经理查询自己创建的营销机会(分页)
	List<Chance> selectChanceByIdByPage(Map map);

	// 添加营销机会
	int insertChance(Chance chance);

	// 修改销售机会的方法(未审核或待修改)
	int updateChance(Chance chance);

	// 客户经理在未审核之前删除销售机会
	int deleteChance(int chid);

	// 通过机会id查询次机会信息
	Chance selectByChid(int chid);

	// 查询客户经理的方法
	List<User> selectManager(String assigneedname);

	// 查询客户经理的方法
	List<User> selectManagerInfo();

	// 通过机会编号查询指派人姓名
	User selectUserName(int chid);

	

}
