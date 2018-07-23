package com.zz624.biz.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zz624.biz.RoleBiz;
import com.zz624.dao.RoleDao;
import com.zz624.entry.Role;
import com.zz624.entry.User;
import com.zz624.util.PageBean;

@Service
public class RoleBizImpl implements RoleBiz {
	@Autowired
	private RoleDao rd;
	
	//查询角色
	@Override
	public Role findRole(int roleid) {
		return rd.selectRole(roleid);
	}
	
	//添加角色
	@Override
	public boolean addRole(Role role) {
		int i = rd.insertRole(role);
		if (i > 0) {
			return true;
		}
		return false;
	}

	//删除角色
	@Override
	public boolean removeRole(Role role) {
		int i = rd.deleteRole(role);
		if (i > 0) {
			return true;
		}
		return false;
	}

	//修改角色
	@Override
	public boolean modifyRole(Role role) {
		int i = rd.updateRole(role);
		if (i > 0) {
			return true;
		}
		return false;
	}

	//查询所有角色
	@Override
	public List<Role> findRoles() {
		return rd.selectRoles();
	}

	//查询所有角色分页
	@Override
	public PageBean findRoles(PageBean pageBean) {
		Map<String, Integer> map = new HashMap<>();
		map.put("currentPage", (pageBean.getCurrentPage() - 1) * pageBean.getPageSize());
		map.put("pageSize", pageBean.getPageSize());
		List<Role> list = rd.selectRoless(map);
		// 将所有的机会信息插入
		pageBean.setDate(list);
		// 设置当前页信息
		//pageBean.setCurrentPage(currentPage);
		// 每页显示条数
		//pb.setPageSize(pageSize);
		// 总条数
		pageBean.setTotalSize(rd.selectRoles().size());
		// 总页数
		pageBean.setTotalPage(pageBean.getTotalPage());
		return pageBean;
	}
}
