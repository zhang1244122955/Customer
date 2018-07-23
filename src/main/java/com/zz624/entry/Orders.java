package com.zz624.entry;

import java.util.Date;

public class Orders {
	//订单编号
	private Integer oid;
	//客户编号
	private Integer custid;
	//客户名称
	private String custname;
	//客户经理id+name
	private Integer userid;
	//用户姓名
	private String name;
	//商品编号
	private Integer gid;
	//商品数量
	private Integer gnum;
	//商品名称
	private String gname;
	//商品成本价格
	private double gcostprice;
	//商品市值价格
	private double gmarketprice;
	//订单报价
	private double ooffer;
	//订单创建时间
	private Date ocreatetime;
	//订单状态
	private String ostatus;
	//销售主管id+name
	private int usercheckid;
	//审核用户人的名字
	private String checkName;
	//订单审核时间
	private Date ochecktime;
	//订单提交状态
	private String osubmitstatus;
	//审核备注
	private String oremarks;

	public Orders() {
		super();
	}

	public Orders(Integer oid, Integer custid, String custname, Integer userid, String name, Integer gid, Integer gnum,
			String gname, double gcostprice, double gmarketprice, double ooffer, Date ocreatetime, String ostatus,
			int usercheckid, String checkName, Date ochecktime, String osubmitstatus, String oremarks) {
		super();
		this.oid = oid;
		this.custid = custid;
		this.custname = custname;
		this.userid = userid;
		this.name = name;
		this.gid = gid;
		this.gnum = gnum;
		this.gname = gname;
		this.gcostprice = gcostprice;
		this.gmarketprice = gmarketprice;
		this.ooffer = ooffer;
		this.ocreatetime = ocreatetime;
		this.ostatus = ostatus;
		this.usercheckid = usercheckid;
		this.checkName = checkName;
		this.ochecktime = ochecktime;
		this.osubmitstatus = osubmitstatus;
		this.oremarks = oremarks;
	}

	public Integer getOid() {
		return oid;
	}

	public void setOid(Integer oid) {
		this.oid = oid;
	}

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

	public Integer getUserid() {
		return userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getGid() {
		return gid;
	}

	public void setGid(Integer gid) {
		this.gid = gid;
	}

	public Integer getGnum() {
		return gnum;
	}

	public void setGnum(Integer gnum) {
		this.gnum = gnum;
	}

	public String getGname() {
		return gname;
	}

	public void setGname(String gname) {
		this.gname = gname;
	}

	public double getGcostprice() {
		return gcostprice;
	}

	public void setGcostprice(double gcostprice) {
		this.gcostprice = gcostprice;
	}

	public double getGmarketprice() {
		return gmarketprice;
	}

	public void setGmarketprice(double gmarketprice) {
		this.gmarketprice = gmarketprice;
	}

	public double getOoffer() {
		return ooffer;
	}

	public void setOoffer(double ooffer) {
		this.ooffer = ooffer;
	}

	public Date getOcreatetime() {
		return ocreatetime;
	}

	public void setOcreatetime(Date ocreatetime) {
		this.ocreatetime = ocreatetime;
	}

	public String getOstatus() {
		return ostatus;
	}

	public void setOstatus(String ostatus) {
		this.ostatus = ostatus;
	}

	public int getUsercheckid() {
		return usercheckid;
	}

	public void setUsercheckid(int usercheckid) {
		this.usercheckid = usercheckid;
	}

	public String getCheckName() {
		return checkName;
	}

	public void setCheckName(String checkName) {
		this.checkName = checkName;
	}

	public Date getOchecktime() {
		return ochecktime;
	}

	public void setOchecktime(Date ochecktime) {
		this.ochecktime = ochecktime;
	}

	public String getOsubmitstatus() {
		return osubmitstatus;
	}

	public void setOsubmitstatus(String osubmitstatus) {
		this.osubmitstatus = osubmitstatus;
	}

	public String getOremarks() {
		return oremarks;
	}

	public void setOremarks(String oremarks) {
		this.oremarks = oremarks;
	}

}
