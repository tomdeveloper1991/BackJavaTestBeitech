package com.beitech.order.utils.exception;

public class InternalServerError extends RuntimeException{
	
	public InternalServerError() {
		super();
	}
	
	public InternalServerError(String message) {
		super(message);
	}

}
