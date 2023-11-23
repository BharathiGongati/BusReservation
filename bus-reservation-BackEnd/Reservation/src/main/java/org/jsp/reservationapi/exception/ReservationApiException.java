package org.jsp.reservationapi.exception;

import org.jsp.reservationapi.dto.ResponseStructure;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ReservationApiException  extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler(IdNotFoundException.class)
	public ResponseEntity<ResponseStructure<String>> handleINFE(IdNotFoundException Exception)
	{
	  ResponseStructure<String> str=new ResponseStructure<>();
	  str.setBody("Id Not found");
	  str.setMessage(Exception.getMessage());
	  str.setCode(HttpStatus.NOT_FOUND.value());
	  return new ResponseEntity<ResponseStructure<String>>(str,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(InvaildCredentialException.class)
	public ResponseEntity<ResponseStructure<String>> handleICE(InvaildCredentialException Exception)
	{
	  ResponseStructure<String> str=new ResponseStructure<>();
	  str.setBody("Admin not found");
	  str.setMessage(Exception.getMessage());
	  str.setCode(HttpStatus.NOT_FOUND.value());
	  return new ResponseEntity<ResponseStructure<String>>(str,HttpStatus.NOT_FOUND);
	}

}
