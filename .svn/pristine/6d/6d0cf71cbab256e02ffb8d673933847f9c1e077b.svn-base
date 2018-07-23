package com.zz624.biz;

import java.util.List;

import com.zz624.entry.Chance;
import com.zz624.entry.Plan;
import com.zz624.entry.User;

public interface PlanBiz {
	
	//通过指派人编号为当前登录者查询所有已经指派人的销售机会
	public List<Chance> findAllChance(String insreach,Integer assigneeid,Integer chid);
	//通过指派人编号为当前登录者查询所有已经指派人的销售机会
	public List<Chance> findAllChance(String insreach,Integer currentPage,Integer assigneeid,Integer chid);
	//添加开发计划
	public boolean addPlan(Plan plan);
	//根据id查询计划表信息
	public Plan findPlan(int planid);
	//根据chid查询计划表信息
	public List<Plan> findSomePlan(String insreach,Integer chid,String planback);
	//根据chid查询计划表信息
	public List<Plan> findSomePlan(String insreach,Integer currentPage,Integer chid,String planback);
	//查询计划表所有信息
	public List<Plan> findAllPlan(String insreach);
	//查询计划表所有信息
	public List<Plan> findAllPlan(String insreach,Integer currentPage);
	//修改开发计划
	public boolean modifyPlan(Plan plan);
	//通过用户id查询权限
	public int findPower(int userid);
	//通过角色名查询用户信息
	public List<User> findUser(String rolename);
}
