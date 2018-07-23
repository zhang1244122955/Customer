package com.zz624.util;

import java.util.ArrayList;
import java.util.List;

public class PageBean {
	private int currentPage;//当前页
	private int pageSize;//每页显示条数
	private int totalPage;//总页数
	private int totalSize;//总条数
	private List date=new ArrayList();//每页要显示的数据
	
	
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	//算法算出总页数
	public int getTotalPage() {
		totalPage=(int) Math.ceil(totalSize/pageSize+1);
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public int getTotalSize() {
		return totalSize;
	}
	public void setTotalSize(int totalSize) {
		this.totalSize = totalSize;
	}
	public List getDate() {
		return date;
	}
	public void setDate(List date) {
		this.date = date;
	}
	
	
	
	
	
	
}
