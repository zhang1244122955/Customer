package com.zz624.biz;

import java.util.List;

import com.zz624.entry.User;
import com.zz624.util.PageBean;

public interface UserBiz {
	// 登录
	User findUser(User user);

	// 查询用户
	User findOwn(User user);
	
	// 查询用户
	User findUserById(Integer userid);

	// 修改密码
	boolean modifyOwn(User user);

	// 添加用户
	boolean addUser(User user);

	// 删除用户
	boolean removeUser(User user);

	// 修改用户
	boolean modifyUser(User user);

	// 查询用户分页
	PageBean findUsers(PageBean pageBean);

	// 查询所有用户
	List<User> findUsers();
	
	//根据角色查用户
	List<User> findUsersByRoleID(User user);
	//人脸登录
	int findUserFace(User user);
	//人脸注册
	int findUserFacePwd(User user);
}
