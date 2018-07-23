package com.zz624.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zz624.biz.PowerBiz;
import com.zz624.entry.Power;
import com.zz624.util.PageBean;
import com.zz624.util.Utils;

@Controller
public class PowerController {
	@Autowired
	private PowerBiz pb;
	@RequestMapping("powerjudge")
	@ResponseBody
	//powerJudge(标签中的id名称,权限,String pos)
	public String powerJudge(String id,Integer power,String pos){
		String[] poss = pos.split(",");
		
		for (String str : poss) {
			if ("".equals(pos)) {
				return id+",display:inlile";
			}
			if(Utils.powerJudge(power, Integer.parseInt(str))){
				return id+",display:inlile";
			}
		}
		return id+",display:none";
	}
	
	@RequestMapping("addPower")
	public String addPower(Power power, HttpServletRequest request){
		System.out.println("---添加权限");
		power.setPowervalue(power.getPowervalue());
		boolean b = pb.addPower(power);
		if (b) {
			return "redirect:";
		}
		return "redirect:";
	}
	
	@RequestMapping("removePower")
	public String removePower(Power power, HttpServletRequest request){
		System.out.println("---删除权限");
		boolean b = pb.removePower(power);
		if (b) {
			return "redirect:";
		}
		return "redirect:";
	}
	
	@RequestMapping("modifyPower")
	public String modifyPower(Power power, HttpServletRequest request){
		System.out.println("---修改权限");
		boolean b = pb.modifyPower(power);
		if (b) {
			return "redirect:";
		}
		return "redirect:";
	}
	
	@RequestMapping("findPower")
	public String findPower(Power power, HttpServletRequest request){
		System.out.println("---查看权限");
		power.setPowervalue(power.getPowervalue());
		Power b = pb.findPower(power);
		if (b != null) {
			return "redirect:";
		}
		return "redirect:";
	}
	
	@RequestMapping("findPowers")
	public String findPowers(PageBean pageBean, HttpServletRequest request){
		System.out.println("---查看所有权限");
		if (request.getParameter("currentPage")==null) {
			pageBean.setCurrentPage(1);
		}else {
			pageBean.setCurrentPage(Integer.valueOf(request.getParameter("currentPage")));
		}
		pageBean.setPageSize(8);
		PageBean pagebean = pb.findPowerss(pageBean);
		if (pagebean != null) {
			request.setAttribute("pageBean", pagebean);
		}
		return "redirect:";
	}
}
