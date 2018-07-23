package com.zz624.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zz624.biz.PlanBiz;
import com.zz624.entry.Chance;
import com.zz624.entry.Plan;
import com.zz624.entry.User;
import com.zz624.util.ProducerService;
import com.zz624.util.Utils;

@Controller
public class PlanController {

	@Autowired
	private PlanBiz pb;
	//日志声明
	Logger logger=LogManager .getLogger();
	//显示所有销售机会
	@RequestMapping("/showAll")
	public String showAll(String insreach,Integer currentPage,HttpServletRequest request,HttpSession session) {
		
		logger.debug("销售主管查看所有销售机会功能");
		if (currentPage==null) {
			currentPage=1;
		}
		if (insreach!=null) {
			insreach="%"+insreach+"%";
		}
		//进行权限判断
		User user=(User) session.getAttribute("user");
		int power=pb.findPower(user.getUserid());
		Boolean boolean1=Utils.powerJudge(power, 1);
		if (boolean1) {
			//判断是销售主管则可以查询所有
			if (Utils.powerJudge(power, 3)||Utils.powerJudge(power, 22)) {
				List<Chance> list=pb.findAllChance(insreach,currentPage, null,null);
				request.setAttribute("list", list);
				request.setAttribute("page", currentPage);
				request.setAttribute("count", pb.findAllChance(insreach,null, null).size());
				return "plan";
			} else {
				//只能通过userid(指派人id)查询自己的销售机会
				int assigneeid=user.getUserid();
				List<Chance> list=pb.findAllChance(insreach,currentPage, assigneeid, null);
				request.setAttribute("list", list);
				request.setAttribute("page", currentPage);
				request.setAttribute("count", pb.findAllChance(insreach,assigneeid, null).size());
				return "plan";
			}
		}
		/*request.setAttribute("pfailmsg", "权限不够/没有进行登陆不可查看计划");*/
		return "";
	}
	//添加计划
	@RequestMapping("/addPlan")
	public String addPlan(int chid,String start,String end,String planname,String planintro,HttpServletRequest request,HttpSession session) {
		
		logger.debug("添加计划功能");
		Plan plan=new Plan();
		plan.setChid(chid);
		plan.setPlanstarttime(start);
		plan.setPlanendtime(end);
		plan.setPlanname(planname);
		plan.setPlanintrol(planintro);
		plan.setPlanback("待开发");
		boolean b=pb.addPlan(plan);
		if (b) {
			User user=(User) session.getAttribute("user");
			int power=pb.findPower(user.getUserid());
			if (Utils.powerJudge(power, 3)) {
				List<User> list=pb.findUser("客户经理");
				ProducerService ps=new ProducerService();
				for (User user1 : list) {
					ps.sendMessage(user1.getUserid().toString(), "您有一个客户开发计划未进行处理");
				}
			}
			return "redirect:markPlan?chid="+chid;
		}
		return "";
	}
	//查看详情和计划页面
	@RequestMapping("/markPlan")
	public String markPlan(String insreach,Integer chid,HttpServletRequest request,HttpSession session) {
		logger.debug("查看详情并制定计划功能");
		if (insreach!=null) {
			insreach="%"+insreach+"%";
		}
		//进行权限判断
		User user=(User) session.getAttribute("user");
		int power=pb.findPower(user.getUserid());
		if (Utils.powerJudge(power, 6)) {
			List<Chance> list=pb.findAllChance(insreach,null, chid);
			Chance chance2=new Chance();
			for (Chance ch : list) {
				chance2=ch;
			}
			//根据chid查看计划
			String planback="待开发";
			List<Plan> list2=pb.findSomePlan(insreach,chid,planback);
			request.setAttribute("listasize", list2.size());
			request.setAttribute("listCh", list2);
			request.setAttribute("chance", chance2);
			//增加计划权限
			if (Utils.powerJudge(power, 7)) {
				request.setAttribute("add", "addtrue");
			}else {
				request.setAttribute("add", "addfalse");
			}
			//3.指派计划权限
			if (Utils.powerJudge(power, 7)) {
				request.setAttribute("zp", "zptrue");
			}else {
				request.setAttribute("zp", "zpfalse");
			}
			return "makeplan";
		}
		return "权限不够";	
	}
	
	//客户经理进行执行计划页面
	@RequestMapping("/executePlan")
	public String executePlan(String insreach,int planid,HttpServletRequest request,HttpSession session) {
		
		logger.debug("客户经理进行执行计划功能");
		if (insreach!=null) {
			insreach="%"+insreach+"%";
		}
		User user=(User) session.getAttribute("user");
		List<Chance> list=pb.findAllChance(insreach,null, user.getUserid());
		Chance chance2=new Chance();
		for (Chance ch : list) {
			chance2=ch;
		}
		Plan plan2=pb.findPlan(planid);
		request.setAttribute("ch", chance2);
		request.setAttribute("plan", plan2);
		return "executeplan";
	}
	//查询所有开发计划的页面
	@RequestMapping("/showAllPlan")
	public String showAllPlan(String insreach,Integer currentPage,HttpServletRequest request) {
		logger.debug("查询所有开发计划功能");
		if (currentPage==null) {
			currentPage=1;
		}
		if (insreach!=null) {
			insreach="%"+insreach+"%";
		}
		List<Plan> list=pb.findAllPlan(insreach,currentPage);
		request.setAttribute("listPlan", list);
		request.setAttribute("page", currentPage);
		request.setAttribute("count", pb.findAllPlan(insreach).size());
		return "showplan";
		
	}
	//修改计划状态
	@RequestMapping("/updatePlan")
	public String updatePlan(int chid,int planid,String planback,HttpServletRequest request) {
		logger.debug("修改计划状态功能");
		Plan plan=new Plan();
		plan.setPlanid(planid);
		plan.setPlanback(planback);
		if (pb.modifyPlan(plan)) {
			return "redirect:markPlan?chid="+chid;
		}
		return "";
		
	}
}
