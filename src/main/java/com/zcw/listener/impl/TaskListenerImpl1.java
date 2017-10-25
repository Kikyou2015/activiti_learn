package com.zcw.listener.impl;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.ExecutionListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TaskListenerImpl1 implements ExecutionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7468484323808183076L;
	private Logger log = LoggerFactory.getLogger(getClass());

	@Override
	public void notify(DelegateExecution execution) throws Exception {
		if ("start".equals(execution.getEventName())) {
			log.info("start----------");
		} else if ("end".equals(execution.getEventName())) {
			log.info("end------------");
		}
	}

}
