package com.zz624.biz.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zz624.biz.PowerBiz;
import com.zz624.dao.PowerDao;
import com.zz624.entry.Power;
import com.zz624.util.PageBean;

@Service
public class PowerBizImpl implements PowerBiz {
	@Autowired
	private PowerDao pd;

	// 增加权限
	@Override
	public boolean addPower(Power power) {
		int i = pd.insertPower(power);
		if (i > 0) {
			return true;
		}
		return false;
	}

	// 删除权限
	@Override
	public boolean removePower(Power power) {
		int i = pd.deletePower(power);
		if (i > 0) {
			return true;
		}
		return false;
	}

	// 修改权限
	@Override
	public boolean modifyPower(Power power) {
		int i = pd.updatePower(power);
		if (i > 0) {
			return true;
		}
		return false;
	}

	// 查询权限
	@Override
	public Power findPower(Power power) {
		return pd.selectPower(power);
	}

	// 查询所有权限
	@Override
	public List<Power> findPowers() {
		return pd.selectPowers();
	}

	// 查询所有权限分页
	@Override
	public PageBean findPowerss(PageBean pageBean) {
		Map<String, Integer> map = new HashMap<>();
		map.put("currentPage", (pageBean.getCurrentPage() - 1) * pageBean.getPageSize());
		map.put("pageSize", pageBean.getPageSize());
		List<Power> list = pd.selectPowerss(map);
		// 将所有的机会信息插入
		pageBean.setDate(list);
		// 设置当前页信息
		//pageBean.setCurrentPage(currentPage);
		// 每页显示条数
		//pb.setPageSize(pageSize);
		// 总条数
		pageBean.setTotalSize(pd.selectPowers().size());
		// 总页数
		pageBean.setTotalPage(pageBean.getTotalPage());
		return pageBean;
	}

}
