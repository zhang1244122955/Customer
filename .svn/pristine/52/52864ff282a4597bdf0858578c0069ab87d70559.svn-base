package com.zz624.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zz624.biz.BroadcastBiz;
import com.zz624.biz.NewsBiz;
import com.zz624.dao.NewsDao;
import com.zz624.entry.Broadcast;
import com.zz624.entry.News;

@Controller
public class TestController {
	
	@Autowired
	BroadcastBiz broadcastBiz;
	@Autowired
	NewsBiz newsBiz;
	
	@RequestMapping(value = "/test")
	public String broadcast(HttpServletRequest request){
		List<Broadcast> list = broadcastBiz.findBroadcast();
		request.setAttribute("list", list);
		
		List<News> news = newsBiz.findAllNewsByStatus(0);
		request.setAttribute("news", news);
		
		return "forward:test.jsp?"+System.currentTimeMillis();
		
	}
}
