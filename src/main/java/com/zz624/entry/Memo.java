package com.zz624.entry;

import java.util.Date;

//备注表
public class Memo {
	//备注编号
	private Integer meid;
	//用户编号(外键)
	private Integer userid;
	//机会编号(外键)
	private Integer chid;
	//备注内容
	private String mecontent;
	//备注时间
	private String metime;
	public Integer getMeid() {
		return meid;
	}
	public void setMeid(Integer meid) {
		this.meid = meid;
	}
	
	
	public Integer getUserid() {
		return userid;
	}
	public void setUserid(Integer userid) {
		this.userid = userid;
	}
	public Integer getChid() {
		return chid;
	}
	public void setChid(Integer chid) {
		this.chid = chid;
	}
	public String getMecontent() {
		return mecontent;
	}
	public void setMecontent(String mecontent) {
		this.mecontent = mecontent;
	}
	public String getMetime() {
		return metime;
	}
	public void setMetime(String metime) {
		this.metime = metime;
	}
	
	
}
