package com.mahendracandi;

import com.mahendracandi.domain.Encryption;
import com.mahendracandi.domain.Messaging;

public class Communication {
	private Messaging messaging;

	private Encryption encryption;
	
	/**
	 * Dependency Injection via constructor
	 */
	public Communication(Encryption encryption) {
		this.encryption = encryption;
	}
	
	/**
	 * Dependency Injection via setter
	 * @param messaging
	 */
	public void setMessaging(Messaging messaging) {
		this.messaging = messaging;
	}
	
	public void communicate() {
		encryption.encryptData();
		messaging.sendMessage();
	}
}
