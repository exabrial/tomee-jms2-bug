package com.github.exabrial;

import javax.annotation.Resource;
import javax.ejb.Lock;
import javax.ejb.LockType;
import javax.ejb.Singleton;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;
import javax.jms.JMSContext;
import javax.jms.Queue;

@Singleton
@TransactionAttribute(TransactionAttributeType.MANDATORY)
@Lock(LockType.READ)
public class ControllerEJB {
	@Inject
	private JMSContext jmsContext;
	@Resource(name = "com.github.exabrial.tomee-bug")
	private Queue queue;

	public void businessFlow() {
		try {
			jmsContext.createProducer().send(queue, "test-text");
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
		throw new XACancellingException();
	}
}
