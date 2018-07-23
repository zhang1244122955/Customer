package com.zz624.entry;

public class Power {
	private Integer powerid;
	private String powername;
	private Integer mpowerid;
	private Integer powervalue;

	public Integer getPowerid() {
		return powerid;
	}

	public void setPowerid(Integer powerid) {
		this.powerid = powerid;
	}

	public String getPowername() {
		return powername;
	}

	public void setPowername(String powername) {
		this.powername = powername;
	}

	public Integer getMpowerid() {
		return mpowerid;
	}

	public void setMpowerid(Integer mpowerid) {
		this.mpowerid = mpowerid;
	}

	public Integer getPowervalue() {
		powervalue = (int) Math.pow(2,powerid-1);
		return powervalue;
	}

	public void setPowervalue(Integer powervalue) {
		this.powervalue = powervalue;
	}

	@Override
	public String toString() {
		return "Power [powerid=" + powerid + ", powername=" + powername + ", mpowerid=" + mpowerid + ", powervalue="
				+ powervalue + "]";
	}
	
}
