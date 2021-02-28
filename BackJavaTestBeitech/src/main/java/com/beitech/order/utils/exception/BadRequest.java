package com.beitech.order.utils.exception;

public class BadRequest extends RuntimeException{
	
	public BadRequest() {
		super();
	}
	
	public BadRequest(String message) {
		super(message);
	}

}
