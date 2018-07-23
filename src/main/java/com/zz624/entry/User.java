package com.zz624.entry;

//User表
public class User {
	// 用户编号
	private Integer userid;
	// 密码
	private String userpwd;
	// 用户角色
	private Role role;
	// 姓名
	private String name;
	// 性别
	private String sex;
	// 手机号
	private String phone;
	// 邮箱
	private String email;
	// 入职时间
	private String hiredate;
	// 出生日期
	private String birthday;
	// 出生日期
	private String facetoken;

	public String getFacetoken() {
		return facetoken;
	}

	public void setFacetoken(String facetoken) {
		this.facetoken = facetoken;
	}

	public Integer getUserid() {
		return userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	public String getUserpwd() {
		return userpwd;
	}

	public void setUserpwd(String userpwd) {
		this.userpwd = userpwd;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getHiredate() {
		return hiredate;
	}

	public void setHiredate(String hiredate) {
		this.hiredate = hiredate;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	@Override
	public String toString() {
		return "User [userid=" + userid + ", userpwd=" + userpwd + ", role=" + role + ", name=" + name + ", sex=" + sex
				+ ", phone=" + phone + ", email=" + email + ", hiredate=" + hiredate + ", birthday=" + birthday
				+ ", facetoken=" + facetoken + "]";
	}

	
}
