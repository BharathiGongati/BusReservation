package org.jsp.reservationapi.dto;

import java.util.List;
import java.util.Optional;

import lombok.Data;

@Data
public class ResponseStructure<T> {
	
	private T body;
	private String message;
	private int code;
//	public T getBody() {
//		return body;
//	}
//	public void setBody(T body) {
//		this.body = body;
//	}
//	public String getMessage() {
//		return message;
//	}
//	public void setMessage(String message) {
//		this.message = message;
//	}
//	public int getCode() {
//		return code;
//	}
//	public void setCode(int code) {
//		this.code = code;
//	}
	

}
