package com.zcw.entitiy;

import java.io.Serializable;
import java.util.Date;

public class TaskForm implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7331296147623273730L;

	private Long taskId;

	private String taskType;

	private String taskDesc;

	private Date day = new Date();

	public TaskForm(Long taskId, String taskType, String taskDesc) {
		super();
		this.taskId = taskId;
		this.taskType = taskType;
		this.taskDesc = taskDesc;
	}

	public Long getTaskId() {
		return taskId;
	}

	public void setTaskId(Long taskId) {
		this.taskId = taskId;
	}

	public String getTaskType() {
		return taskType;
	}

	public void setTaskType(String taskType) {
		this.taskType = taskType;
	}

	public String getTaskDesc() {
		return taskDesc;
	}

	public void setTaskDesc(String taskDesc) {
		this.taskDesc = taskDesc;
	}

	public Date getDay() {
		return day;
	}

	public void setDay(Date day) {
		this.day = day;
	}

}
