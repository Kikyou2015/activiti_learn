package com.zcw.listener.impl;

import org.activiti.engine.delegate.DelegateTask;
import org.activiti.engine.delegate.TaskListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component("waitForAdmissonListener")
public class WaitForAdmissonListener implements TaskListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6869757194914107883L;
	private Logger logger = LoggerFactory.getLogger(getClass());

	@Override
	public void notify(DelegateTask delegateTask) {
		if ("create".equals(delegateTask.getEventName())) {
			logger.info("WaitForAdmisson create--------------");
		} else if ("assignment".equals(delegateTask.getEventName())) {
			logger.info("WaitForAdmisson assignment----------");
		} else if ("complete".equals(delegateTask.getEventName())) {
			logger.info("WaitForAdmisson complete------------");
		}
	}

}
