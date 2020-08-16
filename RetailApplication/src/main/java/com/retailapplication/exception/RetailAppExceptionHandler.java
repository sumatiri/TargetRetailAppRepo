package com.retailapplication.exception;



import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@Component

@ControllerAdvice
public class RetailAppExceptionHandler {
	@ExceptionHandler(Exception.class)
	public ResponseEntity<CustomException> handleRunTimeException(RuntimeException ex) {

		CustomException exceptionResponse = new CustomException(ex.getMessage(), ex.getMessage());

		return new ResponseEntity<CustomException>(exceptionResponse, new HttpHeaders(), HttpStatus.BAD_REQUEST);
	}


}

