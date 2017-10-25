package com.zcw.listener.impl;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.DelegateTask;
import org.activiti.engine.delegate.ExecutionListener;
import org.activiti.engine.delegate.TaskListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TaskListenerImpl1 implements ExecutionListener, TaskListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7468484323808183076L;
	private Logger log = LoggerFactory.getLogger(getClass());

	@Override
	public void notify(DelegateExecution execution) throws Exception {
		log.info("activitiId= {},  activitiName= {}", execution.getCurrentActivityId(),
				execution.getCurrentActivityName());
		if ("start".equals(execution.getEventName())) {
			log.info("start----------");
		} else if ("end".equals(execution.getEventName())) {
			log.info("end------------");
		} else if ("take".equals(execution.getEventName())) {
			log.info("take-----------");
		}
	}

	@Override
	public void notify(DelegateTask delegateTask) {
		if ("create".endsWith(delegateTask.getEventName())) {
			log.info("create-----------");
			if ("writeReport".equals(delegateTask.getTaskDefinitionKey())) {
				delegateTask.setAssignee("a");
				log.info("taskDefinitionKey= {}, assignee= {}", delegateTask.getTaskDefinitionKey(),
						delegateTask.getAssignee());
			} else if ("commitReport".equals(delegateTask.getTaskDefinitionKey())) {
				delegateTask.setAssignee("b");
				log.info("taskDefinitionKey= {}, assignee= {}", delegateTask.getTaskDefinitionKey(),
						delegateTask.getAssignee());
			}
		} else if ("assignment".endsWith(delegateTask.getEventName())) {
			log.info("assignment-------");
		} else if ("complete".endsWith(delegateTask.getEventName())) {
			log.info("complete---------");
		} else if ("delete".endsWith(delegateTask.getEventName())) {
			log.info("delete-----------");
		}
	}

}
