package com.zz624.entry;
//服务管理表
public class Serve {

	//服务编号
	private Integer serveid;
	//服务名称
	private String servename;
	//服务内容
	private String servecontent;
	//客户编号  外键
	private Integer cusid;
	//服务创建人    外键
	private Integer sercreateid;
	//服务创建时间
	private String sercreatetime;
	//服务分配人    外键
	private Integer serassigneid;
	//服务分配时间
	private String serassignetime;
	//服务处理人    外键
	private Integer serdealid;
	//服务处理时间
	private String serdealtime;
	//服务归档时间
	private String serkeeptime;
	//满意度  enum
	private String satisfy;
	//非客户姓名
	private String nocusname;
	//非客户联系电话
	private String nocusphone;
	
	public Integer getServeid() {
		return serveid;
	}
	public void setServeid(Integer serveid) {
		this.serveid = serveid;
	}
	public String getServename() {
		return servename;
	}
	public void setServename(String servename) {
		this.servename = servename;
	}
	public String getServecontent() {
		return servecontent;
	}
	public void setServecontent(String servecontent) {
		this.servecontent = servecontent;
	}
	public Integer getCusid() {
		return cusid;
	}
	public void setCusid(Integer cusid) {
		this.cusid = cusid;
	}
	public Integer getSercreateid() {
		return sercreateid;
	}
	public void setSercreateid(Integer sercreateid) {
		this.sercreateid = sercreateid;
	}
	public String getSercreatetime() {
		return sercreatetime;
	}
	public void setSercreatetime(String sercreatetime) {
		this.sercreatetime = sercreatetime;
	}
	public Integer getSerassigneid() {
		return serassigneid;
	}
	public void setSerassigneid(Integer serassigneid) {
		this.serassigneid = serassigneid;
	}
	public String getSerassignetime() {
		return serassignetime;
	}
	public void setSerassignetime(String serassignetime) {
		this.serassignetime = serassignetime;
	}
	public Integer getSerdealid() {
		return serdealid;
	}
	public void setSerdealid(Integer serdealid) {
		this.serdealid = serdealid;
	}
	public String getSerdealtime() {
		return serdealtime;
	}
	public void setSerdealtime(String serdealtime) {
		this.serdealtime = serdealtime;
	}
	public String getSerkeeptime() {
		return serkeeptime;
	}
	public void setSerkeeptime(String serkeeptime) {
		this.serkeeptime = serkeeptime;
	}
	public String getSatisfy() {
		return satisfy;
	}
	public void setSatisfy(String satisfy) {
		this.satisfy = satisfy;
	}
	public String getNocusname() {
		return nocusname;
	}
	public void setNocusname(String nocusname) {
		this.nocusname = nocusname;
	}
	public String getNocusphone() {
		return nocusphone;
	}
	public void setNocusphone(String nocusphone) {
		this.nocusphone = nocusphone;
	}
	

	
}
