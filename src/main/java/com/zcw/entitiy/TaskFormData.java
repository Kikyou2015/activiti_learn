package com.zcw.entitiy;

import java.io.Serializable;

public class TaskFormData implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2323687141609556572L;

	private Integer day;

	private String type;

	private String reason;

	public TaskFormData(Integer day, String type, String reason) {
		super();
		this.day = day;
		this.type = type;
		this.reason = reason;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public Integer getDay() {
		return day;
	}

	public void setDay(Integer day) {
		this.day = day;
	}

	@Override
	public String toString() {
		return "TaskFormData [day=" + day + ", type=" + type + ", reason=" + reason + "]";
	}

}
