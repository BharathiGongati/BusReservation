package org.jsp.reservationapi.service;

import java.util.Optional;

import org.jsp.reservationapi.dao.UserDao;
import org.jsp.reservationapi.dto.ResponseStructure;
import org.jsp.reservationapi.dto.User;
import org.jsp.reservationapi.exception.IdNotFoundException;
import org.jsp.reservationapi.exception.InvaildCredentialException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	
	@Autowired
	public UserDao udao;

	public ResponseEntity<ResponseStructure<User>> saveUser(User user) {
		ResponseStructure<User> str=new ResponseStructure<>();
		str.setBody(udao.saveUser(user));
		str.setMessage("Sucessfully saved");
		str.setCode(HttpStatus.ACCEPTED.value());
		return new ResponseEntity<ResponseStructure<User>>(str,HttpStatus.ACCEPTED);
	}

	public ResponseEntity<ResponseStructure<User>> updateUser(User user) {
		ResponseStructure<User> str=new ResponseStructure<>();
		str.setBody(udao.updateUser(user));
		str.setMessage("Sucessfully updated");
		str.setCode(HttpStatus.ACCEPTED.value());
		return new ResponseEntity<ResponseStructure<User>>(str,HttpStatus.ACCEPTED);
	}

	public ResponseEntity<ResponseStructure<User>> findById(int id)
	{
		ResponseStructure<User> str=new ResponseStructure<>();
		Optional<User> recdata=udao.findById(id);
		if(recdata.isPresent())
		{
		str.setBody(recdata.get());
		str.setMessage("Sucessfully data feteched");
		str.setCode(HttpStatus.ACCEPTED.value());
		return new ResponseEntity<ResponseStructure<User>>(str,HttpStatus.ACCEPTED);
		}
		throw new IdNotFoundException();
	}
	
	public ResponseEntity<ResponseStructure<User>> verifyByPhone(String email,String password)
	{
		ResponseStructure<User> str=new ResponseStructure<>();
		Optional<User> recdata=udao.verifyByPhone(email,password);
		System.out.println(recdata);
		if(recdata.isPresent())
		{
		str.setBody(recdata.get());
		str.setMessage("Sucessfully user verified");
		str.setCode(HttpStatus.ACCEPTED.value());
		return new ResponseEntity<ResponseStructure<User>>(str,HttpStatus.ACCEPTED);
		}
		throw new InvaildCredentialException();
		
	}
	

}
