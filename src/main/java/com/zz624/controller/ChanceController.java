package com.zz624.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.zz624.util.PageBean;
import com.zz624.util.ProducerService;
import com.zz624.biz.ChanceBiz;
import com.zz624.entry.Chance;
import com.zz624.entry.Role;
import com.zz624.entry.User;
import com.zz624.util.Utils;

@Controller
public class ChanceController {
	@Autowired
	private ChanceBiz chanceBiz;

	/*
	 * @RequestMapping("/paging") public String
	 * paging(@RequestParam(defaultValue = "1") int currentPage,
	 * HttpServletRequest request) { PageBean pageBean =
	 * chanceBiz.selectpaging(currentPage, 8, request);
	 * request.setAttribute("pageBean", pageBean); return "chance-selectall"; }
	 */

	@RequestMapping("/chancepage")
	public String news(@RequestParam(defaultValue = "1") int page, HttpServletRequest request) {
		// 获取登录人的信息
		HttpSession session = request.getSession();
		Role role = (Role) session.getAttribute("role");
		User user = (User) session.getAttribute("user");
		// 查询所有机会的权限
		boolean b1 = Utils.powerJudge(role.getPower(), 1);
		// 有没有指派机会的权限
		boolean b2 = Utils.powerJudge(role.getPower(), 3);
		// 有没有统计报表的权限
		boolean b3 = Utils.powerJudge(role.getPower(), 22);

		if (b2) {
			List<Chance> list = chanceBiz.findAllChancesByPage(page);
			request.setAttribute("list", list);
			request.setAttribute("page", page);
			request.setAttribute("count", chanceBiz.findAllChances());
			return "forward:/chance-selectall.jsp?" + System.currentTimeMillis();
		} else if (b3) {
			List<Chance> list = chanceBiz.findAllChancesByPage(page);
			request.setAttribute("list", list);
			request.setAttribute("page", page);
			request.setAttribute("count", chanceBiz.findAllChances());
			return "forward:/chance-selectall.jsp?" + System.currentTimeMillis();
		}
		System.out.println(page + "--------" + user.getUserid());
		List<Chance> list = chanceBiz.findAllChancesByIdByPage(page, user.getUserid());

		request.setAttribute("list", list);
		request.setAttribute("page", page);
		request.setAttribute("count", chanceBiz.findallbyid(user.getUserid()));
		return "forward:/chance-selectall.jsp?" + System.currentTimeMillis();

	}

	@RequestMapping("/addchance")
	public String addchance(Chance chance, HttpServletRequest request) {
		// 获取登录人的信息
		HttpSession session = request.getSession();
		Role role = (Role) session.getAttribute("role");
		User user = (User) session.getAttribute("user");
		// 有没有添加机会的权限
		boolean b1 = Utils.powerJudge(role.getPower(), 2);
		// 有没有指派机会的权限
		boolean b2 = Utils.powerJudge(role.getPower(), 3);
		if (b1) {
			if (b2) {
				// 自动生成创建人
				chance.setCreateid(user.getUserid());
				// 自动生成创建时间
				Date date1 = new Date();
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
				chance.setChcreatetime(sdf.format(date1));
				// 销售经理添加机会时自动创建指派时间
				Date date2 = new Date();
				chance.setChassigneetime(sdf.format(date2));
				// 进行数据库添加
				chanceBiz.addchance(chance);
				// 创建新的指派人后通知指派人
				ProducerService ps = new ProducerService();

				ps.sendMessage(chance.getAssigneeid().toString(), "您有新的指派信息");
				return "redirect:/chancepage";
			} else {

				// 自动生成创建人
				chance.setCreateid(user.getUserid());
				// 客户经理添加机会审核状态自动为等待审核
				chance.setChstatus("等待审核");
				// 自动生成创建时间
				Date date = new Date();
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
				chance.setChcreatetime(sdf.format(date));
				chanceBiz.addchance(chance);
				return "redirect:/chancepage";
			}
		}

		return "redirect:/chancepage";

	}

	@RequestMapping("/modifychance")
	private String modifychance(Chance chance, HttpServletRequest request) {
		// 获取登录人的信息
		HttpSession session = request.getSession();
		Role role = (Role) session.getAttribute("role");
		User user = (User) session.getAttribute("user");
		// 有没有添加机会的权限
		boolean b1 = Utils.powerJudge(role.getPower(), 2);
		// 有没有指派机会的权限
		boolean b2 = Utils.powerJudge(role.getPower(), 3);
		if (b1) {
			if (b2) {
				Chance chance2 = chanceBiz.findbychid(chance.getChid());
				if (chance2.getAssigneeid() != chance.getAssigneeid()) {

					Date date = new Date();
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
					chance.setChassigneetime(sdf.format(date));
					chanceBiz.modifychance(chance);
					// 创建新的指派人后通知指派人
					ProducerService ps = new ProducerService();
					ps.sendMessage(chance.getAssigneeid().toString(), "您有新的指派信息");
					return "redirect:/chancepage";
				} else if (!chance2.getChstatus().equals(chance.getChstatus())) {// 审核状态改变时
					chanceBiz.modifychance(chance);
					// 审核状态改变后通知创建人
					ProducerService ps = new ProducerService();
					ps.sendMessage(chance.getCreateid().toString(), "您的审核状态已改变");
					return "redirect:/chancepage";
				}else {
					chanceBiz.modifychance(chance);
					return "redirect:/chancepage";
				}
				
				
			}
			chance.setChstatus("等待审核");
			chanceBiz.modifychance(chance);
			return "redirect:/chancepage";
		
		}
		return "redirect:/chancepage";
	}

	@RequestMapping("/modifychanceinfo")
	public String modifychanceinfo(int chid, String chstatus, HttpServletRequest request) {
		// 获取登录人的信息
		HttpSession session = request.getSession();
		Role role = (Role) session.getAttribute("role");
		// 有没有修改机会的权限
		boolean b1 = Utils.powerJudge(role.getPower(), 5);
		// 有没有指派机会的权限
		boolean b2 = Utils.powerJudge(role.getPower(), 3);
		if (b1) {
			if (b2) {
				// 如果他有修改权限就携带所有信息跳转到修改页面
				Chance chance2 = chanceBiz.findbychid(chid);

				request.setAttribute("chance2", chance2);

				User user = chanceBiz.findUserName(chid);
				if (user == null) {
					System.out.println("3333333333333333333333333333");
					request.setAttribute("user", user);
					List<User> list = chanceBiz.findallmanagerinfo();
					request.setAttribute("list", list);
					return "modifychance";
				}
				request.setAttribute("user", user);
				List<User> list = chanceBiz.findallmanager(user.getName());
				request.setAttribute("list", list);
				return "modifychance";
			} else {
				if ("等待审核".equals(chstatus) || "需要修改".equals(chstatus)) {
					// 如果他有修改权限就携带所有信息跳转到修改页面
					Chance chance2 = chanceBiz.findbychid(chid);
					request.setAttribute("chance2", chance2);
					User user = chanceBiz.findUserName(chid);

					if (user == null) {

						List<User> list = chanceBiz.findallmanager(user.getName());

						request.setAttribute("list", list);
						return "modifychance";
					}

					List<User> list = chanceBiz.findallmanager(user.getName());

					request.setAttribute("list", list);
					return "modifychance";
				} else {
					return "redirect:/chancepage";
				}
			}

		}
		return "redirect:/chancepage";

	}

	@RequestMapping("removechance")
	public String removechance(int chid, String chstatus, HttpServletRequest request) {
		// 获取登录人的信息
		HttpSession session = request.getSession();
		Role role = (Role) session.getAttribute("role");
		// 有没有删除机会的权限
		boolean b2 = Utils.powerJudge(role.getPower(), 4);

		if (b2) {

			if ("等待审核".equals(chstatus)) {
				chanceBiz.removechance(chid);
			} else {
				return "redirect:/chancepage";
			}
		}

		return "redirect:/chancepage";

	}

	@RequestMapping("/findmanager")
	public String findmanager(HttpServletRequest request) {
		List<User> list = chanceBiz.findallmanagerinfo();
		request.setAttribute("list", list);
		return "chanceadd";

	}

}
