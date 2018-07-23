package com.zz624.entry;

//Role表
public class Role {
	// 角色编号
	private Integer roleid;
	// 角色名称
	private String rolename;
	// 权限
	private Integer power;

	public Integer getRoleid() {
		return roleid;
	}

	public void setRoleid(Integer roleid) {
		this.roleid = roleid;
	}

	public String getRolename() {
		return rolename;
	}

	public void setRolename(String rolename) {
		this.rolename = rolename;
	}

	public Integer getPower() {
		return power;
	}

	public void setPower(Integer power) {
		this.power = power;
	}

	@Override
	public String toString() {
		return "Role [roleid=" + roleid + ", rolename=" + rolename + ", power=" + power + "]";
	}
}
