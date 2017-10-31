package com.zcw;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.zip.ZipInputStream;

import org.activiti.engine.ManagementService;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.TaskService;
import org.activiti.engine.task.Task;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class QueryTest {

	private Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private ManagementService managementService;

	@Autowired
	private TaskService taskService;

	@Autowired
	private RepositoryService repositoryService;

	@Test
	public void nativeTaskQuery() {

		List<Task> tasks = taskService.createNativeTaskQuery()
				.sql("SELECT * FROM " + managementService.getTableName(Task.class) + " T WHERE T.NAME_ = #{taskName}")
				.parameter("taskName", "部门经理审批").list();

		if (tasks == null)
			return;
		logger.info("taskCount= {}", tasks.size());
		for (Task task : tasks) {
			if (task == null) {
				continue;
			}
			logger.info("taskId= {},taskName= {},taskAssignee= {},taskCreateDate= {}", task.getId(), task.getName(),
					task.getAssignee(), task.getCreateTime());
		}
	}

	@Test
	public void deployProgrammatically() throws FileNotFoundException {
		String barFileName = "d:\\path\\to\\process-one.bar";

		ZipInputStream inputStream = new ZipInputStream(new FileInputStream(barFileName));

		repositoryService.createDeployment().name("process-one.bar").addZipInputStream(inputStream).deploy();
	}
}
