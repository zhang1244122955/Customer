package com.zz624.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zz624.biz.OrdersBiz;
import com.zz624.biz.UserBiz;
import com.zz624.dao.RoleDao;
import com.zz624.entry.Customer;
import com.zz624.entry.Goods;
import com.zz624.entry.Orders;
import com.zz624.entry.Role;
import com.zz624.entry.User;
import com.zz624.util.OrdersFile;
import com.zz624.util.ProducerService;
import com.zz624.util.Utils;

@Controller
public class OrdersController {
	@Autowired
	private OrdersBiz ob;
	@Autowired
	private UserBiz ub;
	@Autowired
	private RoleDao rd;

	Logger logger = LogManager.getLogger();

	ProducerService ps = new ProducerService();

	// 客户经理查看属于自己创建的订单
	@RequestMapping("/showOrdersById")
	public String showAllOrdersById(Integer currentPage, HttpServletRequest request, HttpSession session) {
		logger.debug("客户经理查看属于自己创建的订单");
		// 判断当前页码是否为第一页
		if (currentPage == null) {
			currentPage = 1;
		}
		System.out.println("=======currentPage===========" + currentPage + "=========");
		// 获取当前登录用户的权限
		User user1 = (User) session.getAttribute("user");
		User user2 = ub.findUser(user1);
		Role role = rd.selectRole(user2.getRole().getRoleid());
		// 进行权限的判断(是否是客户经理和查看订单的权限)
		boolean b = Utils.powerJudge(role.getPower(), 9);
		if (b) {
			Integer userid = user2.getUserid();
			// 返回当前页的数据
			Map<String, Integer> map = new HashMap<>();
			map.put("userid", userid);
			map.put("currentPage", (currentPage - 1) * 8);
			List<Orders> list = ob.findAllByid(map);

			for (Orders orders : list) {
				Customer customer = ob.findAllByCustid(orders.getCustid());
				orders.setCustname(customer.getCustname());
				Goods goods = ob.findAllByGid(orders.getGid());
				orders.setGname(goods.getGname());
			}
			// 返回所有数据的条数
			List<Orders> list2 = ob.findAllByid(userid);
			System.out.println("======list2.size()==============" + list2.size());
			request.setAttribute("count", list2.size());

			// 返回当前页
			request.setAttribute("page", currentPage);
			System.out.println("=======currentPage===========" + currentPage + "=========");

			int datasize = list.size();
			List<Customer> Customerlist = ob.AllCustName();
			request.setAttribute("Customerlist", Customerlist);
			request.setAttribute("datasize", datasize);
			request.setAttribute("list", list);
			return "order-list";
		}
		return "order-list";
	}

	// 待用
	// 根据客户名进行模糊查询
	@RequestMapping("/showOrdersByCustName")
	@ResponseBody
	public String showOrdersByCustName(String custname) {
		logger.debug("根据客户名进行模糊查询");
		System.out.println(custname);
		return "index";
	}

	// 当添加新订单的时候选择客户和产品名称
	@RequestMapping("/AllName")
	public String AllCustName(HttpServletRequest request) {
		logger.debug("当客户经理添加新订单的时候选择客户和产品名称");
		List<Customer> Customerlist = ob.AllCustName();
		List<Goods> Goodslist = ob.AllGName();
		request.setAttribute("Customerlist", Customerlist);
		request.setAttribute("Goodslist", Goodslist);
		return "order-add";
	}

	// 待用
	// 当用户生成新订单选择商品根据选择显示商品详情
	@RequestMapping("/findGoodsDetail")
	public String findGoodsDetail(int Custid, HttpServletRequest request) {
		logger.debug("当客户经理添加新订单的时候选择产品后显示具体商品信息");
		Goods goods = ob.findAllByGid(Custid);
		request.setAttribute("goods", goods);
		System.out.println("++++++++++++++++++" + Custid);
		return "order-add";
	}

	// 添加订单
	@RequestMapping("/addOrders")
	public void addOrders(int custid, int gid, int num, double price, HttpServletRequest request, HttpSession session) {
		logger.debug("添加订单");
		System.out.println(custid + "--" + gid + "--" + num + "--" + price);
		Orders orders = new Orders();
		orders.setCustid(custid);
		orders.setGid(gid);
		orders.setGnum(num);
		// 获取当前登录用户的权限
		User user = (User) session.getAttribute("user");
		orders.setUserid(user.getUserid());
		orders.setOcreatetime(new Date());
		orders.setOoffer(price);
		int i = ob.addOrders(orders);
	}

	// 查找单个订单，返回给修改界面
	@RequestMapping("/editorder")
	public String editorder(int oid, HttpServletRequest request) {
		// 根据oid查找订单
		logger.debug("查找单个订单，返回给修改界面");
		Orders orders = ob.findOrdersByOid(oid);
		Customer customer = ob.findAllByCustid(orders.getCustid());
		orders.setCustname(customer.getCustname());
		Goods goods = ob.findAllByGid(orders.getGid());
		orders.setGname(goods.getGname());
		System.out.println(goods.getGname());
		List<Goods> allGName = ob.AllGName();
		request.setAttribute("allGName", allGName);
		request.setAttribute("orders", orders);
		return "order-edit";
	}

	// 修改订单信息
	@RequestMapping("/editOrders")
	public String editOrders(int oid, int gid, int num, double price, HttpServletRequest request) {
		Orders orders = new Orders();
		orders.setOid(oid);
		orders.setGid(gid);
		orders.setGnum(num);
		orders.setOoffer(price);
		ob.editOrders(orders);
		return "redirect:/showOrdersById";
	}

	// 提交订单
	@RequestMapping("/submitOrder")
	public String submitOrder(int oid) {
		logger.debug("提交订单");
		Orders orders = new Orders();
		orders.setOid(oid);
		orders.setOsubmitstatus("已提交");
		ob.editordersSubmit(orders);
		// 将需要审核的信息发送给销售主管
		List<Integer> saleUserid = ob.findAllSaleUserid();
		System.out.println("===================" + saleUserid);
		for (Integer integer : saleUserid) {
			String userid = integer.toString();
			ps.sendMessage(userid, "您有新的订单需要审核！");
		}
		return "redirect:showOrdersById";
	}

	// 审核订单
	@RequestMapping("/ordersExam")
	public String ordersExam(String username, Integer currentPage, HttpServletRequest request, HttpSession session) {
		logger.debug("审核订单");
		// 判断是否有传过来的需要进行模糊查询的客户名称
		if (username == null) {
			// 判断当前页码是否为第一页
			if (currentPage == null) {
				currentPage = 1;
			}
			Map<String, Object> map = new HashMap<>();
			map.put("currentPage", (currentPage - 1) * 8);
			List<Orders> list = ob.findAllStatusCurr(map);
			if (list == null) {
				request.setAttribute("list", list);
				return "order-check";
			}
			for (Orders orders : list) {
				User user = ob.findUser(orders.getUserid());
				orders.setName(user.getName());
				Customer customer = ob.findAllByCustid(orders.getCustid());
				orders.setCustname(customer.getCustname());
				Goods goods = ob.findAllByGid(orders.getGid());
				orders.setGname(goods.getGname());
				orders.setGcostprice(goods.getGcostprice());
				orders.setGmarketprice(goods.getGmarketprice());
			}
			request.setAttribute("list", list);
			request.setAttribute("page", currentPage);
			request.setAttribute("count", ob.findAllStatus().size());
			return "order-check";
		}
		// 判断当前页码是否为第一页
		if (currentPage == null) {
			currentPage = 1;
		}
		// 返回当前页的数据
		Map<String, Object> map = new HashMap<>();
		// 将客户名称塞入到map中
		String custname="%"+username+"%";
		List<Integer> custidlist = ob.findCustidByCustname(custname);
		for (Integer custid : custidlist) {
			System.out.println("--------------------"+custid);
			map.put("custid", custid);
		}

		/* map.put("userid", orders.getUserid()); */
		map.put("currentPage", (currentPage - 1) * 8);
		List<Orders> list = ob.findAllStatusCurr(map);
		if (list == null) {
			request.setAttribute("list", list);
			return "order-check";
		}
		for (Orders orders : list) {
			User user = ob.findUser(orders.getUserid());
			orders.setName(user.getName());
			Customer customer = ob.findAllByCustid(orders.getCustid());
			orders.setCustname(customer.getCustname());
			Goods goods = ob.findAllByGid(orders.getGid());
			orders.setGname(goods.getGname());
			orders.setGcostprice(goods.getGcostprice());
			orders.setGmarketprice(goods.getGmarketprice());
		}
		request.setAttribute("list", list);
		request.setAttribute("page", currentPage);
		request.setAttribute("count", ob.findAllStatus().size());
		return "order-check";
	}

	// 待用
	// 审核订单之显示审核订单的选项
	@RequestMapping("/checkorder")
	public String checkorder(HttpServletRequest request) {

		return "";
	}

	// 修改订单审核状态和备注
	@RequestMapping("/editOstatusRemarks")
	public void editOstatusRemarks(int oid, String submitStatus, String oremark, HttpServletRequest request,
			HttpSession session) {
		logger.debug("修改订单审核状态和备注");
		System.out.println("进入到修改订单审核状态和备注层");
		// 获取当前登录用户
		User user1 = (User) session.getAttribute("user");
		User user2 = ub.findUser(user1);
		Orders orders = new Orders();
		orders.setUsercheckid(user2.getUserid());
		orders.setOchecktime(new Date());
		orders.setOid(oid);
		orders.setOstatus(submitStatus);
		orders.setOremarks(oremark);
		ob.editOstatusAndRemarks(orders);
		Orders orders2 = ob.findOrdersByOid(oid);
		Integer userid = orders2.getUserid();
		String senduserid = userid.toString();
		System.out.println("----------------------" + senduserid);
		// 当审核未通过时提醒创建订单人重新修改报价
		if (submitStatus.equalsIgnoreCase("未通过")) {
			ps.sendMessage(senduserid, "您的订单未通过");
		}
	}

	// 处理订单
	@RequestMapping("dealOrdersShow")
	public String dealorder(Integer currentPage, HttpServletRequest request, HttpSession session) {
		logger.debug("处理订单");
		// 判断当前页码是否为第一页
		if (currentPage == null) {
			currentPage = 1;
		}
		// 获取当前登录用户
		User user1 = (User) session.getAttribute("user");
		User user2 = ub.findUser(user1);
		Integer userid = user2.getUserid();
		// 返回当前页的数据
		Map<String, Integer> map = new HashMap<>();
		map.put("userid", userid);
		map.put("currentPage", (currentPage - 1) * 8);
		List<Orders> dealOrders = ob.findAllDealOrdersCurr(map);
		for (Orders orders : dealOrders) {
			int usercheckid = orders.getUsercheckid();
			User user = ob.findUser(usercheckid);
			orders.setCheckName(user.getName());
			Customer customer = ob.findAllByCustid(orders.getCustid());
			orders.setCustname(customer.getCustname());
			Goods goods = ob.findAllByGid(orders.getGid());
			orders.setGname(goods.getGname());
			int i = orders.getUsercheckid();
			User user3 = new User();
			user.setUserid(i);
			/*
			 * User user3 = ub.findUser(user); orders.setName(user3.getName());
			 */
		}
		// 将当前页传回页面
		request.setAttribute("page", currentPage);
		// 将查询出的需处理的订单总数传给页面
		request.setAttribute("count", ob.findAllDealOrders(userid).size());
		// 将查询分页后的集合传给页面
		request.setAttribute("dealOrders", dealOrders);
		return "order-deal";
	}

	// 订单处理页查看详情
	@RequestMapping("/showDealOrder")
	public String showDealOrder(int orderId, HttpServletRequest request) {
		logger.debug("订单处理查看详情");
		System.out.println(orderId);
		// 根据订单id查找订单详细信息
		Orders orders = ob.findOrdersByOid(orderId);
		Customer customer = ob.findAllByCustid(orders.getCustid());
		orders.setCustname(customer.getCustname());
		Goods goods = ob.findAllByGid(orders.getGid());
		orders.setGname(goods.getGname());
		orders.setGcostprice(goods.getGcostprice());
		orders.setGmarketprice(goods.getGmarketprice());
		int usercheckid = orders.getUsercheckid();
		User user = ob.findUser(usercheckid);
		orders.setCheckName(user.getName());
		request.setAttribute("orders", orders);
		return "order-details";
	}

	// 处理订单的重新报价
	@RequestMapping("/editoofferorder")
	public void editoofferorder(int oid, double price, HttpServletRequest request) {
		logger.debug("处理订单的重新报价");
		// 根据订单id修改订单报价
		Orders orders = new Orders();
		orders.setOid(oid);
		orders.setOoffer(price);
		int i = ob.editOrdersOoffer(orders);
	}

	// 订单重新报价后进行审核状态的修改
	@RequestMapping("/editoofferorderCheck")
	public String editoofferorderCheck(int oid, HttpServletRequest request) {
		System.out.println("进入到修改状态层");
		int i = ob.editOrderOofferCheck(oid);
		return "redirect:dealOrdersShow";
	}

	// 订单归档，显示所有订单
	@RequestMapping("/showAllFinshOrders")
	public String showAllFinshOrders(Integer currentPage, HttpServletRequest request) {
		logger.debug("订单归档");
		// 判断当前页码是否为第一页
		if (currentPage == null) {
			currentPage = 1;
		}
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("currentPage", (currentPage - 1) * 8);
		List<Orders> orders = ob.findAllFinshOrdersCurr(map);
		for (Orders orders2 : orders) {
			Customer customer = ob.findAllByCustid(orders2.getCustid());
			orders2.setCustname(customer.getCustname());
			Goods goods = ob.findAllByGid(orders2.getGid());
			orders2.setGname(goods.getGname());
		}
		request.setAttribute("orders", orders);
		request.setAttribute("page", currentPage);
		request.setAttribute("count", ob.findAllFinshOrders().size());
		return "order-finsh";

	}

	@RequestMapping("/exportOrders")
	public String exportOrders() {
		// 建立一个Excel
		// Workbook book = new HSSFWorkbook();
		// 在对应的Excel中建立一个分表
		// Sheet sheet1 =(Sheet) book.createSheet("分表1");
		// 设置相应的行（初始从0开始）
		// Row row =sheet1.createRow(0);
		// 在所在的行设置所在的单元格（相当于列，初始从0开始,对应的就是A列）
		// Cell cell = row.createCell(0);
		// 写入相关数据到设置的行列中去。
		// cell.setCellValue("相关数据");
		OrdersFile of = new OrdersFile();
		try {
			of.Export();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 保存到计算机相应路径
		// try {
		// book.write( new FileOutputStream("F://a.xls"));
		// } catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		// e.printStackTrace();
		// } catch (IOException e) {
		// TODO Auto-generated catch block
		// e.printStackTrace();
		// }

		return "redirect:showAllFinshOrders";
	}
	
	//统计分析  -- 查找所有客户名称
	@RequestMapping("/selectAllCustAna")
	public String selectAllCustAna(HttpServletRequest request){
		List<Customer> custName = ob.AllCustName();
		request.setAttribute("custNameList", custName);
		return "order-analysis";
	}
}
