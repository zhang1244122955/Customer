package com.zz624.controller;

import java.io.OutputStream;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zz624.biz.RoleBiz;
import com.zz624.biz.UserBiz;
import com.zz624.biz.impl.UserBizImpl;
import com.zz624.entry.Role;
import com.zz624.entry.User;
import com.zz624.util.MD5util;
import com.zz624.util.PageBean;
import com.zz624.util.Utils;

//用户控制层
@Controller
public class UserController {
	@Autowired
	private UserBiz ub;
	@Autowired
	private RoleBiz rb;

	@RequestMapping("/login")
	@ResponseBody
	public String Login(User user, HttpSession session) {
		System.out.println("---登录");
		//对密码进行加密
		user.setUserpwd(MD5util.getPwd(user.getUserpwd()));
		User own = ub.findUser(user);
		if (own != null) {
			System.out.println("---查询角色");
			Role role = rb.findRole(own.getRole().getRoleid());
			session.setAttribute("user", own);
			session.setAttribute("role", role);
			return "true";
		}else{
			return "false";
		}
	}

	@RequestMapping("/modifyOwn")
	public String modifyOwn(User user, HttpServletRequest request) {
		System.out.println("---修改密码");
		//对密码进行加密
		user.setUserpwd(MD5util.getPwd(user.getUserpwd()));
		boolean b = ub.modifyOwn(user);
		if (b) {
			return "redirect:login.jsp";
		}
		return "redirect:login.jsp";
	}

	@RequestMapping("/addUser")
	public String addUser(User user, Role role, HttpServletRequest request) {
		System.out.println("---添加用户");
		user.setRole(role);
		//对密码进行加密
		user.setUserpwd(MD5util.getPwd(user.getUserpwd()));
		boolean b = ub.addUser(user);
		if (b) {
			return "redirect:findUsers";
		}
		return "redirect:findUsers";
	}

	@RequestMapping("/removeUser")
	public String removeUser(User user, HttpServletRequest request) {
		System.out.println("---删除用户");
		boolean b = ub.removeUser(user);
		if (b) {
			return "redirect:findUsers";
		}
		return "redirect:findUsers";
	}

	@RequestMapping("/modifyUser")
	public String modifyUser(User user, Role role, HttpServletRequest request) {
		System.out.println("---修改用户");
		user.setRole(role);
		boolean b = ub.modifyUser(user);
		if (b) {
			return "redirect:findUsers";
		}
		return "redirect:findUsers";
	}

	@RequestMapping("/findUser")
	public String findOwn(User user, HttpServletRequest request) {
		System.out.println("---查询用户");
		User own = ub.findOwn(user);
		List<Role> roles = rb.findRoles();
		if (own != null) {
			request.setAttribute("u", own);
			request.setAttribute("roles", roles);
			return "user-modify";
		}
		return "user-list";
	}

	@RequestMapping("/findRoless")
	public String findUser(User user, HttpServletRequest request) {
		System.out.println("---查询所有权限");
		List<Role> findRoles = rb.findRoles();
		if (findRoles != null) {
			request.setAttribute("roles", findRoles);
			return "user-add";
		}
		return "user-list";
	}

	@RequestMapping("/findUsers")
	public String findUsers(PageBean pageBean, HttpSession session, HttpServletRequest request) {
		System.out.println("---查询所有用户");
		Role role = (Role) session.getAttribute("role");
		User user = (User) session.getAttribute("user");
		// 查询所有机会的权限
		boolean b1 = Utils.powerJudge(role.getPower(), 17);
		boolean b2 = Utils.powerJudge(role.getPower(), 19);
		if (request.getParameter("currentPage") == null) {
			pageBean.setCurrentPage(1);
		} else {
			pageBean.setCurrentPage(Integer.valueOf(request.getParameter("currentPage")));
		}
		pageBean.setPageSize(8);
		if (b1) {
			// 系统管理员能查看所有的用户
			PageBean pagebean = ub.findUsers(pageBean);
			if (pagebean != null) {
				request.setAttribute("pageBean", pagebean);
				return "user-list";
			}
		} else if (b2) {
			// 高管能查看所有的用户
			PageBean pagebean = ub.findUsers(pageBean);
			if (pagebean != null) {
				request.setAttribute("pageBean", pagebean);
				return "user-list";
			}
		}
		return "user-list";
	}
	
	@RequestMapping("/facelogin")
	@ResponseBody
	public String faceLogin(User user, HttpSession session) {
		System.out.println("---人脸登录");
		
		
		// 切掉字符串没用部分
		user.setFacetoken(user.getFacetoken().substring(22)); 

		int code = 0;

		if("".equals(user.getUserpwd())){
			//调用人脸登录方法获得结果
			code = ub.findUserFace(user);
		}else{
			//通过密码开通人脸识别
			//对密码进行加密
			user.setUserpwd(MD5util.getPwd(user.getUserpwd()));
			code = ub.findUserFacePwd(user);
		}
		
		if(code == 10002000){
			//如果成功登陆，就把用户名存入session
			User own = ub.findUserById(user.getUserid());
			Role role = rb.findRole(own.getRole().getRoleid());
			session.setAttribute("user", own);
			session.setAttribute("role", role);
		}
		return ""+code;
	}
}
