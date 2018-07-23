package com.zz624.biz.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zz624.biz.NewsBiz;
import com.zz624.dao.NewsDao;
import com.zz624.entry.News;
@Service
public class NewsBizImpl implements NewsBiz {

	@Autowired
	private NewsDao newsDao;
	
	@Override
	public int findAllNews() {
		// 查看所有新闻
		return newsDao.selectNews();
	}

	@Override
	public int removeNews(Integer newsid) {
		// 删除新闻
		return newsDao.deleteNews(newsid);
	}

	@Override
	public int modifyNews(News news) {
		// 修改新闻
		return newsDao.updateNews(news);
	}

	@Override
	public int addNews(News news) {
		// 添加新闻
		return newsDao.insertNews(news);
	}

	@Override
	public News findNewsById(Integer newsid) {
		// TODO Auto-generated method stub
		return newsDao.selectNewsById(newsid);
	}

	@Override
	public List<News> findAllNewsByPage(int page) {
		int num = (page-1)*8;
		//查看新闻（分页）
		return newsDao.selectNewsByPage(num);
	}

	@Override
	public List<News> findAllNewsByStatus(int status) {
		// 查看可见新闻
		return newsDao.selectNewsByStatus(status);
	}

}
