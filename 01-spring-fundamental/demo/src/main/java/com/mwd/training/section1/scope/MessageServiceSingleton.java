package com.mwd.training.section1.scope;

import org.springframework.stereotype.Component;

@Component
//@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
public class MessageServiceSingleton implements MessageService {

	private String message;

	@Override
	public String getMessage() {
		return message;
	}

	@Override
	public void setMessage(String message) {
		this.message = "[SINGLETON]" + message;
	}
}