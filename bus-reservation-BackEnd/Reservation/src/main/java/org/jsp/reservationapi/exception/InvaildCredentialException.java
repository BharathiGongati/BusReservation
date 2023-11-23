package org.jsp.reservationapi.exception;

public class InvaildCredentialException  extends RuntimeException{
	@Override
	public String getMessage() {
		return "invaild phone number and password";
	}

}
