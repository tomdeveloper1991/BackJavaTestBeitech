package com.beitech.order.utils;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import com.beitech.order.utils.exception.BadRequest;
import com.beitech.order.utils.exception.InternalServerError;
import com.beitech.order.utils.exception.NotFoundException;

@ControllerAdvice(annotations = RestController.class)
public class ExceptionConfig {
	
	@ExceptionHandler(NotFoundException.class)
	public ResponseEntity<?> notFoundException(Exception e){
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
	}
	
	@ExceptionHandler(BadRequest.class)
	public ResponseEntity<?> badRequestException(Exception e){
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
	}
	
	@ExceptionHandler(InternalServerError.class)
	public ResponseEntity<?> internalServerErrorException(Exception e){
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
	}

}
