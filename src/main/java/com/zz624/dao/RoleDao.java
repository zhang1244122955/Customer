package com.zz624.dao;

import java.util.List;
import java.util.Map;

import com.zz624.entry.Role;

public interface RoleDao {
	// 查询角色
	Role selectRole(int roleid);

	// 添加角色
	int insertRole(Role role);

	// 删除角色
	int deleteRole(Role role);

	// 修改角色
	int updateRole(Role role);

	// 查询所有角色分页
	List<Role> selectRoless(Map map);

	// 查询所有角色
	List<Role> selectRoles();
}
