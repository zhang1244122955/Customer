package com.zz624.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zz624.biz.NewsBiz;
import com.zz624.entry.News;

@Controller
public class NewsController {
	@Autowired
	private NewsBiz newsBiz;

	// 让newsmanager.jsp页面有数据
	@RequestMapping(value = "/news")
	public String news(int page,HttpServletRequest request) {
		List<News> list = newsBiz.findAllNewsByPage(page);
		request.setAttribute("list", list);
		request.setAttribute("page", page);
		request.setAttribute("count", newsBiz.findAllNews());
		return "forward:/newsmanager.jsp?" + System.currentTimeMillis();

	}

	// 删除新闻
	@RequestMapping(value = "/removeNews")
	@ResponseBody
	public String removeNews(Integer newsid, HttpServletRequest request) {

		newsBiz.removeNews(newsid);
		return "";
	}

	// 修改新闻
	@RequestMapping(value = "/modifyNews")
	@ResponseBody
	public String modifyNews(News news, HttpServletRequest request) {
		// 防止新闻状态为空
		if (news.getNewsstatus() == null) {
			news.setNewsstatus(1);
		}
		newsBiz.modifyNews(news);
		return "";
	}

	// 添加新闻
	@RequestMapping(value = "/addNews")
	@ResponseBody
	public String addNews(News news, HttpServletRequest request) {
		// 防止新闻状态为空
		if (news.getNewsstatus() == null) {
			news.setNewsstatus(1);
		}
		newsBiz.addNews(news);
		return "";
	}

	// 让news-modify.jsp页面有数据
	@RequestMapping(value = "/beforeModify")
	public String beforeModify(Integer newsid, HttpServletRequest request) {
		News news = newsBiz.findNewsById(newsid);
		request.setAttribute("news", news);
		return "news-modify";

	}
}
