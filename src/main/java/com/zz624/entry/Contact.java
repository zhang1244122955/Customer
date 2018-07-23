package com.zz624.entry;

//客户联系人信息表
public class Contact {

	// 联系人编号
	private Integer contactid;
	//客户编号(外键)
	private Integer custid;
	//客户联系人名称
	private String name;
	//联系方式
	private String phone;

	public Integer getContactid() {
		return contactid;
	}

	public void setContactid(Integer contactid) {
		this.contactid = contactid;
	}

	

	public Integer getCustid() {
		return custid;
	}

	public void setCustid(Integer custid) {
		this.custid = custid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

}
