package com.zz624.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zz624.biz.RoleBiz;
import com.zz624.entry.Role;
import com.zz624.entry.User;
import com.zz624.util.PageBean;
//角色控制层
@Controller
public class RoleController {
	@Autowired
	private RoleBiz rb;

	@RequestMapping("/findOwn")
	public String findOwn(HttpSession session, HttpServletRequest request) {
		System.out.println("---查询角色");
		User user = (User) session.getAttribute("user");
		Role role = rb.findRole(user.getRole().getRoleid());
		if (role != null) {
			session.setAttribute("role", role);
			return "index";
		}
		return "index";
	}

	@RequestMapping("/addRole")
	public String addRole(Role role, HttpServletRequest request) {
		System.out.println("---添加角色");
		String[] values = request.getParameterValues("choose");
		int sum = 0;
		if (values != null && values.length > 0) {
			for (int i = 0; i < values.length; i++) {
				sum += Integer.parseInt(values[i]);
			}
		}
		role.setPower(sum);
		boolean b = rb.addRole(role);
		if (b) {
			return "redirect:findRoles";
		}
		return "redirect:findRoles";
	}

	@RequestMapping("/removeRole")
	public String removeRole(Role role, HttpServletRequest request) {
		System.out.println("---删除角色");
		boolean b = rb.removeRole(role);
		if (b) {
			return "redirect:findRoles";
		}
		return "redirect:findRoles";
	}

	@RequestMapping("/modifyRole")
	public String modifyRole(Role role, HttpServletRequest request) {
		System.out.println("---修改角色");
		String[] values = request.getParameterValues("chooses");
		System.out.println(values);
		int sum = 0;
		if (values != null && values.length > 0) {
			for (int i = 0; i < values.length; i++) {
				sum += Integer.parseInt(values[i]);
			}
		}
		role.setPower(sum);
		boolean b = rb.modifyRole(role);
		if (b) {
			return "redirect:findRoles";
		}
		return "redirect:findRoles";
	}
	
	@RequestMapping("/findRole")
	public String findRole(int roleid, HttpServletRequest request) {
		System.out.println("---查询角色");
		Role role = rb.findRole(roleid);
		if (role != null) {
			request.setAttribute("roleo", role);
			return "role-modify";
		}
		return "role-list";
	}

	@RequestMapping("/findRoles")
	public String findRoles(PageBean pageBean, HttpServletRequest request) {
		System.out.println("---查询所有角色");
		if (request.getParameter("currentPage")==null) {
			pageBean.setCurrentPage(1);
		}else {
			pageBean.setCurrentPage(Integer.valueOf(request.getParameter("currentPage")));
		}
		pageBean.setPageSize(8);
		PageBean pagebean = rb.findRoles(pageBean);
		if (pagebean != null) {
			request.setAttribute("pageBean", pagebean);
			return "role-list";
		}
		return "role-list";
	}
}
