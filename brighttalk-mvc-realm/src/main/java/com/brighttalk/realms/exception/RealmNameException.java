package com.brighttalk.realms.exception;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.BAD_REQUEST)
public class RealmNameException extends Exception {

	public RealmNameException() {
		super();
	}
	public RealmNameException(String message) {
		super(message);
	}
}
