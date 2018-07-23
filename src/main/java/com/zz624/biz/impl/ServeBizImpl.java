package com.zz624.biz.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zz624.biz.PlanBiz;
import com.zz624.biz.ServeBiz;
import com.zz624.dao.ServeDao;
import com.zz624.entry.Contact;
import com.zz624.entry.Customer;
import com.zz624.entry.Serve;
import com.zz624.entry.User;

@Service
public class ServeBizImpl implements ServeBiz {

	@Autowired
	private ServeDao sd;
	@Autowired
	private PlanBiz pb;

	@Override
	public List<Serve> findAllServe(Integer currentPage,String insearch) {
		Map<String, Object> map=new HashMap<>();
		map.put("currentPage", (currentPage - 1) * 8);
		map.put("insearch", insearch);
		return sd.selectAllServe(map);
	}
	@Override
	public List<Serve> findAllServe(String insearch) {
		Map<String, String> map=new HashMap<>();
		map.put("insearch", insearch);
		return sd.selectAllServe(map);
	}
	@Override
	public Serve findServe(int serveid) {
		Serve serve= sd.selectServe(serveid);
		return serve;
	}

	public String findCusName(int custid) {
		return sd.selectCusName(custid);

	}

	@Override
	public boolean addServe(Serve serve) {
		int i = sd.insertServe(serve);
		if (i > 0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean modifyServe(Serve serve) {
		int i = sd.updateServe(serve);
		if (i > 0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean modifySerdealtime(Serve serve) {
		int i = sd.updateSerdealtime(serve);
		if (i > 0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean modifySersatisfy(Serve serve) {
		int i = sd.updateSersatisfy(serve);
		if (i > 0) {
			return true;
		}
		return false;
	}
	
	@Override
	public boolean modifySerkeeptime(String serkeeptime) {
		int i= sd.updateSerkeeptime(serkeeptime);
		if (i > 0) {
			return true;
		}
		return false;
	}
	
	@Override
	public List<Serve> findServeByCreateOrDeal(String insearch,Integer currentPage, Integer sercreateid, Integer serdealid) {
		Map<String, Object> map=new HashMap<>();
		map.put("insearch", insearch);
		map.put("currentPage", (currentPage - 1) * 8);
		map.put("sercreateid", sercreateid);
		map.put("serdealid", serdealid);
		return sd.selectAllServe(map);
	}
	@Override
	public List<Serve> findServeByCreateOrDeal(String insearch,Integer sercreateid, Integer serdealid) {
		Map<String, Object> map=new HashMap<>();
		map.put("insearch", insearch);
		map.put("sercreateid", sercreateid);
		map.put("serdealid", serdealid);
		return sd.selectAllServe(map);
	}
	@Override
	public List<Serve> findServeByDeal(String insearch,Integer currentPage,Integer serdealid) {
		Map<String, Object> map=new HashMap<>();
		map.put("insearch", insearch);
		map.put("currentPage", (currentPage - 1) * 8);
		map.put("serdealid", serdealid);
		return sd.selectAllServe(map);
	}
	@Override
	public List<Serve> findServeByDeal(String insearch,Integer serdealid) {
		Map<String, Object> map=new HashMap<>();
		map.put("insearch", insearch);
		map.put("serdealid", serdealid);
		return sd.selectAllServe(map);
	}

	@Override
	public List<Customer> findAllCus() {
		return sd.selectAllCus();
	}

	@Override
	public List<User> findAllCusManager() {
		int roleid = sd.selectCusManRoleId("客户经理");
		return sd.selectAllCusManager(roleid);
	}

	@Override
	public List<Contact> selectConPh() {
		return sd.selectConPh();
	}
}
