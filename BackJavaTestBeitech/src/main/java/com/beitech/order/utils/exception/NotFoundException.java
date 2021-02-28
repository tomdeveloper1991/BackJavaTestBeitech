package com.beitech.order.utils.exception;

public class NotFoundException extends RuntimeException{
	
	public NotFoundException() {
		super();
	}
	
	public NotFoundException(String message) {
		super(message);
	}
}
