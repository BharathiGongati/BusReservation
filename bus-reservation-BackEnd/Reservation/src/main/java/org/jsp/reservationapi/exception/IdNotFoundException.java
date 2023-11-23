package org.jsp.reservationapi.exception;

public class IdNotFoundException extends RuntimeException{
	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return "ID not found";
	}

}
