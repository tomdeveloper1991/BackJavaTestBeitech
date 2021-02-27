package com.beitech.order.dto;

public class ResponseDto{
	private Integer codeError;
	private String responseMessage;
	
	public ResponseDto(Integer codeError, String responseMessage) {
		super();
		this.codeError=codeError;
		this.responseMessage=responseMessage;
	}

	public Integer getCodeError() {
		return codeError;
	}

	public void setCodeError(Integer codeError) {
		this.codeError = codeError;
	}

	public String getResponseMessage() {
		return responseMessage;
	}

	public void setResponseMessage(String responseMessage) {
		this.responseMessage = responseMessage;
	}
	
	
	
}
