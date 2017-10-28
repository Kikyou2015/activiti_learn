package com.zcw;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.zcw.entitiy.TaskForm;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CandidateUserTest {

	@Autowired
	private RuntimeService runtimeService;

	@Autowired
	private TaskService taskService;

	@Test
	public void flowStart() {
		Map<String, Object> map = new HashMap<>();
		map.put("user", "a");// 注意这是，对应${user}
		ProcessInstance processInstance = runtimeService.startProcessInstanceByKey("leaveProcessAssignee", map);
		System.out.println(processInstance.getId());// 流程图id
	}

	@Test
	public void flowStartByListener() {
		runtimeService.startProcessInstanceByKey("leaveProcessAssignee");
	}

	@Test
	public void completeTask() {
		Map<String, Object> map = new HashMap<>();
		map.put("user", "a");
		String taskId = "120014";
		taskService.complete(taskId, map);
		System.out.println("完成任务，任务ID:" + taskId);
	}

	@Test
	public void findMyPersonTask() {
		String assignee = "b";
		List<Task> taskList = taskService.createTaskQuery()// 创建查询对象
				.taskAssignee(assignee)// 指定查询人
				.list();
		if (taskList.size() > 0) {
			for (Task task : taskList) {
				System.out.println("代办任务ID:" + task.getId());
				System.out.println("代办任务name:" + task.getName());
				System.out.println("代办任务创建时间:" + task.getCreateTime());
				System.out.println("代办任务办理人:" + task.getAssignee());
				System.out.println("流程实例ID:" + task.getProcessInstanceId());
				System.out.println("执行对象ID:" + task.getExecutionId());
			}
		}

	}

	@Test
	public void completeMyTask() {
		String taskId = "195002";
		taskService.complete(taskId);
		System.out.println("完成任务，任务ID:" + taskId);
	}
}
