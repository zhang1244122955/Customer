package com.zz624.dao;

import java.util.List;
import java.util.Map;

import com.zz624.entry.News;

public interface NewsDao {
	// 添加新闻
	int insertNews(News news);

	// 删除新闻
	int deleteNews(Integer newsid);

	// 修改新闻
	int updateNews(News news);

	// 查找新闻数量（分页用）
	int selectNews();

	// 查找所有新闻(分页)
	List<News> selectNewsByPage(int page);

	// 通过id查找新闻
	News selectNewsById(Integer newsid);
	
	//查找可见新闻
	List<News> selectNewsByStatus(int status);
}
