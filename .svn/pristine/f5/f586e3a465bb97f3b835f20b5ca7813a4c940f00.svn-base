package com.zz624.entry;

import java.util.List;

//客户表
public class Customer {
	// 客户编号
	private Integer custid;
	// 名称
	private String custname;
	// 地址
	private String custaddress;
	// 经理(我方负责人)(外键)
	private Integer userid;
	// 等级(枚举)
	private String custlevel;
	// 传真
	private String custfax;
	// 客户状态
	private String custstate;
	// 暂缓流失信息
	private String stopwastageinfo;
	// 确认流失信息
	private String determinestageinfo;

	public String getStopwastageinfo() {
		return stopwastageinfo;
	}

	public void setStopwastageinfo(String stopwastageinfo) {
		this.stopwastageinfo = stopwastageinfo;
	}

	public String getDeterminestageinfo() {
		return determinestageinfo;
	}

	public void setDeterminestageinfo(String determinestageinfo) {
		this.determinestageinfo = determinestageinfo;
	}

	public String getCuststate() {
		return custstate;
	}

	public void setCuststate(String custstate) {
		this.custstate = custstate;
	}

	// 一个客户可以有多个客户联系人
	private List<Contact> contacts;

	public Integer getCustid() {
		return custid;
	}

	public void setCustid(Integer custid) {
		this.custid = custid;
	}

	public String getCustname() {
		return custname;
	}

	public void setCustname(String custname) {
		this.custname = custname;
	}

	public String getCustaddress() {
		return custaddress;
	}

	public void setCustaddress(String custaddress) {
		this.custaddress = custaddress;
	}

	public Integer getUserid() {
		return userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	public String getCustlevel() {
		return custlevel;
	}

	public void setCustlevel(String custlevel) {
		this.custlevel = custlevel;
	}

	public String getCustfax() {
		return custfax;
	}

	public void setCustfax(String custfax) {
		this.custfax = custfax;
	}

	public List<Contact> getContacts() {
		return contacts;
	}

	public void setContacts(List<Contact> contacts) {
		this.contacts = contacts;
	}

	@Override
	public String toString() {
		return "Customer [custid=" + custid + ", custname=" + custname + ", custaddress=" + custaddress + ", userid="
				+ userid + ", custlevel=" + custlevel + ", custfax=" + custfax + ", contacts=" + contacts + "]";
	}
}
