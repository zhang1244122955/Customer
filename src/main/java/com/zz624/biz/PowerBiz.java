package com.zz624.biz;

import java.util.List;

import com.zz624.entry.Power;
import com.zz624.util.PageBean;

public interface PowerBiz {
	// 增加权限
	boolean addPower(Power power);

	// 删除权限
	boolean removePower(Power power);

	// 修改权限
	boolean modifyPower(Power power);

	// 查询权限
	Power findPower(Power power);

	// 查询所有权限
	List<Power> findPowers();

	// 查询所有权限分页
	PageBean findPowerss(PageBean pageBean);
}
