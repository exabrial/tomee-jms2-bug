package com.github.exabrial;

import java.util.Date;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.jms.Message;
import javax.jms.MessageListener;

@MessageDriven(activationConfig = { @ActivationConfigProperty(propertyName = "maxSessions", propertyValue = "1"),
		@ActivationConfigProperty(propertyName = "destination", propertyValue = "com.github.exabrial.tomee-bug"),
		@ActivationConfigProperty(propertyName = "maximumRedeliveries", propertyValue = "3") })
@TransactionAttribute(TransactionAttributeType.REQUIRED)
public class ListenerMDB implements MessageListener {

	@Override
	public void onMessage(Message message) {
		System.out.println("ack:" + new Date());
	}
}
