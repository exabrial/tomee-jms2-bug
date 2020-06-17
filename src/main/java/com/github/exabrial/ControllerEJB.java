package com.github.exabrial;

import java.util.Date;

import javax.annotation.Resource;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.jms.Queue;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import com.emoneyusa.TestObject;
import com.emoneyusa.xcut.jms.JmsSender;

@ApplicationScoped
@Transactional(TxType.REQUIRED)
public class ControllerEJB {
	@Inject
	private JmsSender jmsSender;
	@Resource(name = "com.github.exabrial.tomee-bug")
	private Queue queue;

	public void businessFlow() {
		try {
			jmsSender.sendToQueue(new TestObject());
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
		System.out.println("controller complete:" + new Date());
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
		// throw new WebApplicationException("msg");
	}
}
