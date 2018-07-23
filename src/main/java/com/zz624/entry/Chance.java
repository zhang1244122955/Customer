package com.zz624.entry;

import java.util.Date;
//销售机会表
public class Chance {

	//机会编号
	private Integer chid;
	//客户名称
	private String custname;
	//成功几率(枚举)
	private String chsuccess;
	//概要
	private String choutline;
	//联系人
	private String chcontact;
	//联系人电话
	private String chcontactphone;
	//机会描述
	private String chdescribe;
	//创建人(外键)
	private Integer createid;
	//创建时间
	private String chcreatetime;
	//指派时间
	private String chassigneetime;
	//指派人编号(外键)
	private Integer assigneeid;
	//审核状态
	private String chstatus;

	public String getChstatus() {
		return chstatus;
	}

	public void setChstatus(String chstatus) {
		this.chstatus = chstatus;
	}

	public Integer getChid() {
		return chid;
	}

	public void setChid(Integer chid) {
		this.chid = chid;
	}

	public String getCustname() {
		return custname;
	}

	public void setCustname(String custname) {
		this.custname = custname;
	}

	public String getChsuccess() {
		return chsuccess;
	}

	public void setChsuccess(String chsuccess) {
		this.chsuccess = chsuccess;
	}

	public String getChoutline() {
		return choutline;
	}

	public void setChoutline(String choutline) {
		this.choutline = choutline;
	}

	public String getChcontact() {
		return chcontact;
	}

	public void setChcontact(String chcontact) {
		this.chcontact = chcontact;
	}

	public String getChcontactphone() {
		return chcontactphone;
	}

	public void setChcontactphone(String chcontactphone) {
		this.chcontactphone = chcontactphone;
	}

	public String getChdescribe() {
		return chdescribe;
	}

	public void setChdescribe(String chdescribe) {
		this.chdescribe = chdescribe;
	}
	

	public String getChcreatetime() {
		return chcreatetime;
	}

	public void setChcreatetime(String chcreatetime) {
		this.chcreatetime = chcreatetime;
	}

	public String getChassigneetime() {
		return chassigneetime;
	}

	public void setChassigneetime(String chassigneetime) {
		this.chassigneetime = chassigneetime;
	}

	public Integer getCreateid() {
		return createid;
	}

	public void setCreateid(Integer createid) {
		this.createid = createid;
	}

	public Integer getAssigneeid() {
		return assigneeid;
	}

	public void setAssigneeid(Integer assigneeid) {
		this.assigneeid = assigneeid;
	}

	@Override
	public String toString() {
		return "Chance [chid=" + chid + ", custname=" + custname + ", chsuccess=" + chsuccess + ", choutline="
				+ choutline + ", chcontact=" + chcontact + ", chcontactphone=" + chcontactphone + ", chdescribe="
				+ chdescribe + ", createid=" + createid + ", chcreatetime=" + chcreatetime + ", chassigneetime="
				+ chassigneetime + ", assigneeid=" + assigneeid + ", chstatus=" + chstatus + "]";
	}

	

	

}
