package com.zz624.biz.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zz624.biz.PlanBiz;
import com.zz624.dao.PlanDao;
import com.zz624.entry.Chance;
import com.zz624.entry.Plan;
import com.zz624.entry.User;
@Service
public class PlanBizImpl implements PlanBiz {

	@Autowired
	private PlanDao pd;

	//通过指派人编号为当前登录者查询所有已经指派人的销售机会
	//查询所有销售机会（销售主管登录时）
	@Override
	public List<Chance> findAllChance(String insreach,Integer assigneeid,Integer chid) {
		Map<String, Object> map=new HashMap<>();
		map.put("in", insreach);
		map.put("assigneeid", assigneeid);
		map.put("chid", chid);
		return pd.selectAllChance(map);
	}
	@Override
	public List<Chance> findAllChance(String insreach,Integer currentPage,Integer assigneeid,Integer chid) {
		Map<String, Object> map=new HashMap<>();
		map.put("insreach", insreach);
		map.put("currentPage",  (currentPage - 1) * 8);
		map.put("assigneeid", assigneeid);
		map.put("chid", chid);
		return pd.selectAllChance(map);
	}
	@Override
	public boolean addPlan(Plan plan) {
		int i=pd.insertPlan(plan);
		if (i>0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean modifyPlan(Plan plan) {
		int i=pd.updatePlan(plan);
		if (i>0) {
			return true;
		}
		return false;
	}
	@Override
	public Plan findPlan(int planid) {
		Plan plan=pd.selectAPlan(planid);
		return plan;
	}
	@Override
	public List<Plan> findAllPlan(String insreach) {
		Map<String, Object> map=new HashMap<>();
		map.put("insreach", insreach);
		return pd.selectAllPlan(map);
	}
	@Override
	public List<Plan> findAllPlan(String insreach,Integer currentPage) {
		Map<String, Object> map=new HashMap<>();
		map.put("insreach", insreach);
		map.put("currentPage",  (currentPage - 1) * 8);
		return pd.selectAllPlan(map);
	}
	@Override
	public List<Plan> findSomePlan(String insreach,Integer chid,String planback) {
		Map<String, Object> map=new HashMap<>();
		map.put("insreach", insreach);
		map.put("chid", chid);
		map.put("planback", planback);
		return pd.selectAllPlan(map);
	}
	@Override
	public List<Plan> findSomePlan(String insreach,Integer currentPage,Integer chid,String planback) {
		Map<String, Object> map=new HashMap<>();
		map.put("insreach", insreach);
		map.put("currentPage",  (currentPage - 1) * 8);
		map.put("chid", chid);
		map.put("planback", planback);
		return pd.selectAllPlan(map);
	}
	@Override
	public int findPower(int userid) {
		int roleid=pd.selectRoleId(userid);
		int power=pd.selectPower(roleid);
		return power;
	}
	@Override
	public List<User> findUser(String rolename) {
		int roleid=pd.selectRoleIdByName(rolename);
		List<User> list=pd.selectUserByUId(roleid);
		return list;
	}

}
