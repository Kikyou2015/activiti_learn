package com.zcw;

import java.util.HashMap;
import java.util.Map;

import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.zcw.entitiy.TaskFormData;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ConditionTest {

	private Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private RuntimeService runtimeService;

	@Autowired
	TaskService taskService;

	@Test
	public void startTask() {
		runtimeService.startProcessInstanceByKey("conditionProcess");
	}

	@Test
	public void completeTask() {
		String taskId = "247504";

		Map<String, Object> map = new HashMap<>();
		map.put("user", "a");

		taskService.setVariable(taskId, "param1", "Kikyou");
		taskService.complete(taskId, map);

		logger.info("完成任务ID:{}", taskId);
	}

	@Test
	public void getVariable() {
		String taskId = "250004";
		Object paramValue = taskService.getVariable(taskId, "param1");
		logger.info("paramValue= {}", paramValue);
	}

	@Test
	public void completeFormTask() {
		Map<String, Object> map = new HashMap<>();

		TaskFormData taskFormData = new TaskFormData(3, "事假", "今天老子不想上班");

		map.put("user", "b");

		String taskId = "262517";

		taskService.setVariable(taskId, "taskForm", taskFormData);
		taskService.complete(taskId, map);

		logger.info("完成任务，任务ID: {}", taskId);
	}

	@Test
	public void getFormTaskVariable() {
		String taskId = "255006";
		TaskFormData taskFormData = (TaskFormData) taskService.getVariable(taskId, "taskForm");
		logger.info(taskFormData.toString());
	}

	@Test
	public void offDaysCountCondition() {
		Map<String, Object> map = new HashMap<>();
		map.put("user", "a");
		map.put("day", 2);

		String taskId = "240004";
		taskService.complete(taskId, map);

		logger.info("完成任务，任务ID:{}", taskId);
	}

	@Test
	public void submitManagerApply() {
		Map<String, Object> map = new HashMap<>();
		map.put("user", "admin");
		map.put("day", 4);

		String taskId = "265012";
		taskService.complete(taskId, map);

		logger.info("完成任务，任务ID:{}", taskId);		
	}
}
