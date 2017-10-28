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
		String taskId = "212505";
		taskService.complete(taskId);

		logger.info("完成任务ID:{}", taskId);
	}

	@Test
	public void offDaysCountCondition() {
		Map<String, Object> map = new HashMap<>();
		map.put("user", "a");
		map.put("day", 2);

		String taskId = "217502";
		taskService.complete(taskId, map);

		logger.info("完成任务，任务ID:{}", taskId);
	}
}
