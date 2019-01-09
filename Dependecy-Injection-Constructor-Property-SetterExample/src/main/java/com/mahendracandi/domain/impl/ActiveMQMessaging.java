package com.mahendracandi.domain.impl;

import com.mahendracandi.domain.Messaging;

public class ActiveMQMessaging implements Messaging {

	public void sendMessage() {
		System.out.println("Sending message via active MQ");
	}
}
