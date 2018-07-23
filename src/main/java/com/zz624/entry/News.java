package com.zz624.entry;

public class News {
	//新闻ID
	private Integer newsid;
	//新闻标题
	private String newstitle;
	//新闻状态
	private Integer newsstatus;
	//新闻日期
	private String newsdate;
	public Integer getNewsid() {
		return newsid;
	}
	public void setNewsid(Integer newsid) {
		this.newsid = newsid;
	}
	public String getNewstitle() {
		return newstitle;
	}
	public void setNewstitle(String newstitle) {
		this.newstitle = newstitle;
	}
	public Integer getNewsstatus() {
		return newsstatus;
	}
	public void setNewsstatus(Integer newsstatus) {
		this.newsstatus = newsstatus;
	}
	public String getNewsdate() {
		return newsdate;
	}
	public void setNewsdate(String newsdate) {
		this.newsdate = newsdate;
	}
	@Override
	public String toString() {
		return "News [newsid=" + newsid + ", newstitle=" + newstitle + ", newsstatus=" + newsstatus + ", newsdate="
				+ newsdate + "]";
	}
	
	
}
