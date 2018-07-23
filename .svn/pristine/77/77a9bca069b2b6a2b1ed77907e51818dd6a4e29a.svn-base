package com.zz624.dao;

import java.util.List;
import java.util.Map;

import com.zz624.entry.Chance;
import com.zz624.entry.Plan;
import com.zz624.entry.User;

//客户开发计划
public interface PlanDao {
	//查询所有已经指派人的销售机会
	public List<Chance> selectAllChance(Map map);
	//根据planid查询计划
	public Plan selectAPlan(int planid);
	//添加开发计划
	public int insertPlan(Plan plan);
	//修改开发计划
	public int updatePlan(Plan plan);
	//查看开发计划
	public List<Plan> selectAllPlan(Map map);
	//通过用户id查询角色id
	public int selectRoleId(int userid);
	//通过角色id查询角色power
	public int selectPower(int roleid);
	//通过角色名查询角色id
	public int selectRoleIdByName(String rolename);
	//通过角色id查询用户信息
	public List<User> selectUserByUId(int roleid);
}
