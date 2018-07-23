package com.zz624.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zz624.biz.PlanBiz;
import com.zz624.biz.ServeBiz;
import com.zz624.entry.Contact;
import com.zz624.entry.Customer;
import com.zz624.entry.Serve;
import com.zz624.entry.User;
import com.zz624.util.ProducerService;
import com.zz624.util.ServeFile;
import com.zz624.util.Utils;

@Controller
public class ServeController {

	@Autowired
	private PlanBiz pb;
	@Autowired
	private ServeBiz sb;
	//日志声明
	Logger logger=LogManager.getLogger();
	
	//查询所有服务（创建服务页面）
	@RequestMapping("/showAllServe")
	public String showAllServe(String insearch,Integer currentPage,HttpServletRequest request,HttpSession session) {
		logger.debug("查询所有服务（创建服务页面）功能");
		if (currentPage==null) {
			currentPage=1;
		}
		if (insearch!=null) {
			insearch="%"+insearch+"%";
		}
		List<Serve> list=sb.findAllServe(currentPage,insearch);
		User user=(User) session.getAttribute("user");
		int power=pb.findPower(user.getUserid());
		List<String> listCus=new ArrayList<>();
		if (Utils.powerJudge(power, 14)) {
			//是该客户经理创建的服务
			int sercreateid=user.getUserid();
			//是该客户经理处理的服务
			int serdealid=user.getUserid();
			List<Serve> list2=sb.findServeByCreateOrDeal(insearch,currentPage, sercreateid, serdealid);
			List<String> listCus1=new ArrayList<>();
			
				for (Serve serve : list2) {
					listCus1.add(sb.findCusName(serve.getCusid()));
				}
			
			request.setAttribute("list", list2);
			request.setAttribute("listCus", listCus1);
			request.setAttribute("page", currentPage);
			request.setAttribute("count", sb.findServeByCreateOrDeal(insearch,sercreateid, serdealid).size());
			return "serve";
		}
		for (Serve serve : list) {
			listCus.add(sb.findCusName(serve.getCusid()));
		}
		request.setAttribute("list", list);
		request.setAttribute("listCus", listCus);
		request.setAttribute("page", currentPage);
		request.setAttribute("count", sb.findAllServe(insearch).size());
		return "serve";
		
	}
	//查询所有服务（处理和反馈服务页面）
		@RequestMapping("/showAllADServe")
		public String showAllADServe(String insearch,Integer currentPage,HttpServletRequest request,HttpSession session) {
			logger.debug("查询所有服务（处理和反馈服务页面）功能");
			if (currentPage==null) {
				currentPage=1;
			}
			if (insearch!=null) {
				insearch="%"+insearch+"%";
			}
			List<Serve> list=sb.findAllServe(currentPage,insearch);
			List<Serve> list1=sb.findAllServe(insearch);
			User user=(User) session.getAttribute("user");
			//是该客户经理创建的服务
			int sercreateid=user.getUserid();
			//是该客户经理处理的服务
			int serdealid=user.getUserid();
			List<Serve> list2=sb.findServeByCreateOrDeal(insearch,currentPage, sercreateid, serdealid);
			List<String> listCus1=new ArrayList<>();
			
			for (Serve serve : list2) {
				listCus1.add(sb.findCusName(serve.getCusid()));
			}
			request.setAttribute("list", list2);
			request.setAttribute("listCus1", listCus1);
			request.setAttribute("page", currentPage);
			request.setAttribute("count", sb.findServeByCreateOrDeal(insearch,sercreateid, serdealid).size());
			return "showadServe";
		}
	//根据serveid查询服务
	@RequestMapping("/showServe")
	public String showServe(int serveid,HttpServletRequest request,HttpSession session) {
		logger.debug("根据serveid查询服务功能");
		Serve serve=sb.findServe(serveid);
		request.setAttribute("Serve", serve);
		String cusname=sb.findCusName(serve.getCusid());
		request.setAttribute("cusname", cusname);
		return "showallserve";
	}
	//创建服务前对所有客户进行下拉菜单的选择
	@RequestMapping("/showAllCus")
	public String showAllCus(HttpServletRequest request) {
		logger.debug("创建服务前对所有客户进行下拉菜单的选择功能");
		List<Customer> listCustomer=sb.findAllCus();
		List<Contact> listCon=sb.selectConPh();
		request.setAttribute("lengthCus", listCustomer.size());
		request.setAttribute("listCustomer", listCustomer);
		request.setAttribute("lengthCon", listCon.size());
		request.setAttribute("listCon", listCon);
		return "serve-add";
		
	}
	//创建服务
	@RequestMapping("/createServe")
	public String createServe(Serve serve,HttpServletRequest request,HttpSession session) {
		logger.debug("创建服务功能");
		User user=(User) session.getAttribute("user");
		int sercreateid=user.getUserid();
		serve.setSercreateid(sercreateid);
		Date date=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		serve.setSercreatetime(sdf.format(date));
		if (sb.addServe(serve)) {
			List<User> list=pb.findUser("高管");
			ProducerService ps=new ProducerService();
			for (User user1 : list) {
				ps.sendMessage(user1.getUserid().toString(), "您有一个服务需要进行分配");
			}
		}
		return "redirect:showAllServe";
		
	}
	//根据serveid查询服务
		@RequestMapping("/showServegg")
		public String showServegg(int serveid,HttpServletRequest request,HttpSession session) {
			logger.debug("根据serveid查询服务功能");
			Serve serve=sb.findServe(serveid);
			request.setAttribute("Serve", serve);
			User user=(User) session.getAttribute("user");
			int power=pb.findPower(user.getUserid());
			if (Utils.powerJudge(power, 22)) {
				List<User> listUser=sb.findAllCusManager();
				request.setAttribute("length", listUser.size());
				request.setAttribute("listUser", listUser);
				return "modifyAssignee";
			}
			return "showallserve";
		}
	//查询未分派服务
	@RequestMapping("/showNoAssigneServe")
	public String showNoAssigneServe(String insearch,Integer currentPage,HttpServletRequest request) {
		logger.debug("查询未分派服务功能");
		if (currentPage==null) {
			currentPage=1;
		}
		if (insearch!=null) {
			insearch="%"+insearch+"%";
		}
		List<Serve> list=sb.findAllServe(insearch);
		List<Serve> listServe=new ArrayList<Serve>();
		for (Serve serve : list) {
			if (serve.getSerassigneid()==null) {
				listServe.add(serve);
			}
		}
		request.setAttribute("listServe", listServe);
		request.setAttribute("page", currentPage);
		request.setAttribute("count", listServe.size());
		return "assigneeser";
		
	}
	
	//分派服务
	@RequestMapping("/assigneServe")
	public void assigneServe(int serveid,int serdealid,HttpSession session) {
		logger.debug("分派服务功能");
		User user=(User) session.getAttribute("user");
		int serassigneid=user.getUserid();
		Date date=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String serassignetime=sdf.format(date);
		Serve serve=new Serve();
		serve.setServeid(serveid);
		serve.setSerassigneid(serassigneid);
		serve.setSerassignetime(serassignetime);
		serve.setSerdealid(serdealid);
		if (sb.modifyServe(serve)) {
			List<User> list=pb.findUser("客户经理");
			ProducerService ps=new ProducerService();
			for (User user1 : list) {
				ps.sendMessage(user1.getUserid().toString(), "您有一个服务未进行处理");
			}
			//return "redirect:showServegg?serveid="+serveid;
		}
		//return "redirect:showServegg?serveid="+serveid;
	}
	//查询已经分派了但还没有处理的服务
	@RequestMapping("/showNoDealServe")
	public String showNoDealServe(String insearch,Integer currentPage,HttpSession session,HttpServletRequest request) {
		logger.debug("查询已经分派了但还没有处理的服务功能");
		if (currentPage==null) {
			currentPage=1;
		}
		if (insearch!=null) {
			insearch="%"+insearch+"%";
		}
		User user=(User) session.getAttribute("user");
		int serdealid=user.getUserid();
		List<Serve> list=sb.findServeByDeal(insearch,currentPage,serdealid);
		List<Serve> listdeal=new ArrayList<Serve>();
		for (Serve serve : list) {
			if (serve.getSerdealtime()==null||serve.getSerdealtime().length()<3) {
				listdeal.add(serve);
			}
		}
		System.out.println(listdeal.size());
		request.setAttribute("listdeal", listdeal);
		request.setAttribute("page", currentPage);
		request.setAttribute("count", listdeal.size());
		return "dealser";
		
	}
	//处理服务结果
	@RequestMapping("/DealServe")
	public String DealServe(int serveid) {
		logger.debug("处理服务功能");
		Date date=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String serdealtime=sdf.format(date);
		Serve serve=new Serve();
		serve.setServeid(serveid);
		serve.setSerdealtime(serdealtime);
		if (sb.modifySerdealtime(serve)) {
			return "redirect:showNoDealServe";
		}
		return null;
	}
	//查询没有进行服务反馈的服务
	@RequestMapping("/showNoSersatisfy")
	public String showNoSersatisfy(String insearch,Integer currentPage,HttpSession session,HttpServletRequest request) {
		logger.debug("查询没有进行服务反馈的服务功能");
		if (currentPage==null) {
			currentPage=1;
		}
		if (insearch!=null) {
			insearch="%"+insearch+"%";
		}
		//只有本处理服务这可以进行反馈
		User user=(User) session.getAttribute("user");
		int serdealid=user.getUserid();
		List<Serve> list=sb.findServeByDeal(insearch,currentPage,serdealid);
		List<Serve> listSatisfy=new ArrayList<Serve>();
		for (Serve serve : list) {
			if (serve.getSatisfy()==null) {
				listSatisfy.add(serve);
			}
		}
		request.setAttribute("listSatisfy", listSatisfy);
		request.setAttribute("page", currentPage);
		request.setAttribute("count", listSatisfy.size());
		//System.currentTimeMillis()时间戳，自动更新
		return "showSerSatisfy";
	}
	//服务反馈
	@RequestMapping("/serveBack")
	public void serveBack(int serveid,String satisfy) {
		logger.debug("服务反馈功能");
		Serve serve=new Serve();
		serve.setServeid(serveid);
		serve.setSatisfy(satisfy);
		if (sb.modifySersatisfy(serve)) {
			List<User> list=pb.findUser("高管");
			ProducerService ps=new ProducerService();
			for (User user1 : list) {
				ps.sendMessage(user1.getUserid().toString(), "您有一个服务未进行归档处理");
			}
		}
	}
	//查询所有要归档的服务内容
	@RequestMapping("/showFileServe")
	public String showFileServe(String insearch,Integer currentPage,HttpServletRequest request,HttpSession session) {
		logger.debug("查询所有要归档的服务内容功能");
		if (currentPage==null) {
				currentPage=1;
		}
		if (insearch!=null) {
			insearch="%"+insearch+"%";
		}
		List<Serve> list=sb.findAllServe(currentPage,insearch);
		request.setAttribute("list", list);
		request.setAttribute("page", currentPage);
		request.setAttribute("count", sb.findAllServe(insearch).size());
		return "Serve_file";	
	}
	//服务归档到Excel文件
	public final static String url = "jdbc:mysql://123.206.52.239:3306/customer"; // 数据库URL
    public final static String user = "customer"; // 数据库用户名
    public final static String password = "customer"; // 数据库密码
	@RequestMapping("/serveFile")
	public String serveFile(HttpServletRequest request){
		logger.debug("查询所有要归档的服务内容功能");
	    ServeFile sf=new ServeFile();
	    try {
			sf.outServe(url, user, password);
			//修改数据库服务归档时间
			Date date=new Date();
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			String serkeeptime=sdf.format(date);
			if (sb.modifySerkeeptime(serkeeptime)) {
				return "redirect:showFileServe";
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:showFileServe";
	}
	//根据服务创建时间对服务进行统计分析
	@RequestMapping("/reportServeCrTime")
	public String reportServeCrTime(HttpServletRequest request) {
		logger.debug("根据服务创建时间对服务进行统计分析功能");
		List<Serve> list=sb.findAllServe(null);
		List<String> createlist=new ArrayList<>();
		for (Serve serve : list) {
			String time=serve.getSercreatetime();
			//将2018-07-04 03:07:55拆分成2018-07-04和03:07:55
			String[] date=time.split(" ");
			//将2018-07-04拆分成2018和07和04
			String[] t=date[0].split("-");
			String createtime=t[0]+","+t[1]+","+t[2];
			createlist.add(createtime);
		}
		request.setAttribute("createlist", createlist);
		return "serve_report";
	}
	//根据服务处理人及满意度对服务进行统计分析
		@RequestMapping("/reportServeSat")
		public String reportServeSat(HttpServletRequest request) {
			logger.debug("根据服务处理人及满意度对服务进行统计分析功能");
			List<Serve> list=sb.findAllServe(null);
			List<Integer> deallist=new ArrayList<>();
			List<String> satlist=new ArrayList<>();
			for (Serve serve : list) {
				int serdealid=serve.getSerdealid();
				deallist.add(serdealid);
				String satisfy=serve.getSatisfy();
				satlist.add(satisfy);
			}
			request.setAttribute("deallist", deallist);
			request.setAttribute("satlist", satlist);
			return "Serve_report_sat";
		}
	//根据客户对服务进行统计分析
	@RequestMapping("/reportServeCus")
	public String reportServeCus(HttpServletRequest request) {
		logger.debug("根据客户对服务进行统计分析功能");
		List<Serve> list=sb.findAllServe(null);
		List<String> cuslist=new ArrayList<>();
		for (Serve serve : list) {
			int cusid=serve.getCusid();
			String cusname=sb.findCusName(cusid);
			cuslist.add(cusname);
		}
		request.setAttribute("cuslist", cuslist);
		return "Serve_report_cusid";
	}
}
