package com.zz624.biz;

import java.util.List;

import com.zz624.entry.News;

public interface NewsBiz {

	// 查看新闻条数
	int findAllNews();

	// 查看所有新闻(分页)
	List<News> findAllNewsByPage(int page);

	// 查看可见新闻
	List<News> findAllNewsByStatus(int status);

	// 查看新闻(通过id)
	News findNewsById(Integer newsid);

	// 删除新闻
	int removeNews(Integer newsid);

	// 修改新闻
	int modifyNews(News news);

	// 添加新闻
	int addNews(News news);
}
