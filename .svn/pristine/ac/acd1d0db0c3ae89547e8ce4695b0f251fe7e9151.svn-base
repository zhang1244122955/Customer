package com.zz624.biz.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zz624.biz.ChanceBiz;
import com.zz624.dao.ChanceDao;
import com.zz624.entry.Chance;
import com.zz624.entry.Role;
import com.zz624.entry.User;
import com.zz624.util.PageBean;
import com.zz624.util.Utils;

@Service
public class ChanceBizImpl implements ChanceBiz {
	@Autowired
	private ChanceDao dao;
	@Override
	public int findAllChances() {
		return dao.selectChance();
	}
	@Override
	public List<Chance> findAllChancesByPage(int page) {
		int num = (page-1)*8;
		return dao.selectChanceByPage(num);
	}
	
	@Override
	public int findallbyid(int createid) {
		return dao.selectChanceById(createid);
		
	}
	@Override
	public List<Chance> findAllChancesByIdByPage(int page,int createid) {
		int num=(page-1)*8;
		System.out.println(num+"+++++++++"+createid);
		Map<String,Integer> map=new HashMap<>();
		map.put("page", num);
		map.put("createid", createid);
		return dao.selectChanceByIdByPage(map);
	}
	
	@Override
	public boolean addchance(Chance chance) {
		System.out.println("fewfwfewffw");
		int n = dao.insertChance(chance);
		if (n > 0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean modifychance(Chance chance) {
		int n = dao.updateChance(chance);
		if (n > 0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean removechance(int chid) {
		int n = dao.deleteChance(chid);
		if (n > 0) {
			return true;
		}
		return false;
	}

	

	@Override
	public Chance findbychid(int chid) {
		Chance chance = dao.selectByChid(chid);
		if (chance != null) {
			return chance;
		}
		return null;
	}

	

	@Override
	public List<User> findallmanager(String assigneedname) {
		List<User> list=dao.selectManager(assigneedname);
		if (list!=null) {
			return list;
		}
		return null;
	}
	@Override
	public PageBean selectpaging(int currentPage, int pageSize, HttpServletRequest request) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public User findUserName(int chid) {
		
		return dao.selectUserName(chid);
	}
	@Override
	public List<User> findallmanagerinfo() {
		
		return dao.selectManagerInfo();
	}
	
	
	
	
	
}
