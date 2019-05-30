package com.brighttalk.realms.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;



//this annotation is because this Controller has to be shared among all the controllers
@ControllerAdvice
public class CustomizedResponseEntityExceptionHandler 
extends ResponseEntityExceptionHandler{
//need to override this method from ResponseEntityExceptionHandler
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Object> handleAllException(Exception ex, WebRequest request) throws Exception {
		//here we have to return the Exception bean class created.
		Error exceptionresponse =new Error(ex.getMessage());
		return new ResponseEntity<Object>(exceptionresponse,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	@ExceptionHandler(RealmNotFoundException.class)
	public final ResponseEntity<Object> handleUserException(RealmNotFoundException ex, WebRequest request) throws Exception {
		Error exceptionresponse = new Error(ex.getMessage());
		return new ResponseEntity<Object>(exceptionresponse,HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(InvalidArgumentException.class)
	public final ResponseEntity<Object> handleUserException(InvalidArgumentException ex, WebRequest request) throws Exception {
		Error exceptionresponse = new Error(ex.getMessage());
		return new ResponseEntity<Object>(exceptionresponse,HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(RealmNameException.class)
	public final ResponseEntity<Object> handleUserException(RealmNameException ex, WebRequest request) throws Exception {
		System.out.println("REalm name exception in exception handler");
		Error exceptionresponse = new Error(ex.getMessage());
		System.out.println( ex.getMessage());
		return new ResponseEntity<Object>(exceptionresponse,HttpStatus.BAD_REQUEST);
		
	}

}
