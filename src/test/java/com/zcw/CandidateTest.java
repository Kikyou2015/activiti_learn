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
public class CandidateTest {

	private Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private TaskService taskService;

	@Autowired
	private RuntimeService runtimeService;

	@Test
	public void startTask() {
		runtimeService.startProcessInstanceByKey("conditionProcess");
	}

	@Test
	public void completeTask() {
		String taskId = "282517";
		Map<String, Object> map = new HashMap<>();
		map.put("user", "a");
		map.put("users", "a,b,c,admin");

		taskService.complete(taskId, map);
	}

	@Test
	public void completeCandidateTask() {
		Map<String, Object> map = new HashMap<>();
		TaskFormData taskFormData = new TaskFormData(3, "事假", "今天老子");
		map.put("day", taskFormData.getDay());

		String taskId = "";

		taskService.setVariable(taskId, "taskForm", taskFormData);
		taskService.complete(taskId, map);

		logger.info("完成任务，任务ID: {}", taskId);
	}

	@Test
	public void claim() {
		String taskId = "290020";

		String userId = "b";

		taskService.claim(taskId, userId);
	}

	@Test
	public void assignee() {
		String taskId = "290020";

		String userId = "z";

		taskService.setAssignee(taskId, userId);
	}

	@Test
	public void addGroupUser() {
		String taskId = "290020";
		String userId = "z";

		taskService.addCandidateUser(taskId, userId);
	}

	@Test
	public void deleteGroupUser() {
		String taskId = "290020";
		String userId = "z";

		taskService.deleteCandidateUser(taskId, userId);
	}
}
