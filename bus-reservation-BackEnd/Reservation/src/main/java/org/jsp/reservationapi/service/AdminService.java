package org.jsp.reservationapi.service;

import java.util.Optional;

import org.jsp.reservationapi.dao.AdminDao;
import org.jsp.reservationapi.dto.Admin;
import org.jsp.reservationapi.dto.ResponseStructure;
import org.jsp.reservationapi.exception.IdNotFoundException;
import org.jsp.reservationapi.exception.InvaildCredentialException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class AdminService {
	
	@Autowired
	public AdminDao dao;
	
	public ResponseEntity<ResponseStructure<Admin>> saveAdmin(Admin admin)
	{
		ResponseStructure<Admin> str=new ResponseStructure<>();
		str.setBody(dao.saveAdmin(admin));
		str.setMessage("Sucessfully saved");
		str.setCode(HttpStatus.ACCEPTED.value());
		return new ResponseEntity<ResponseStructure<Admin>>(str,HttpStatus.ACCEPTED);
	}

	public ResponseEntity<ResponseStructure<Admin>> updateAdmin(Admin admin) {
		ResponseStructure<Admin> str=new ResponseStructure<>();
		str.setBody(dao.updateAdmin(admin));
		str.setMessage("Sucessfully updated");
		str.setCode(HttpStatus.ACCEPTED.value());
		return new ResponseEntity<ResponseStructure<Admin>>(str,HttpStatus.ACCEPTED);
	}

	public ResponseEntity<ResponseStructure<Admin>> findById(int id) {
		ResponseStructure<Admin> str=new ResponseStructure<>();
		Optional<Admin> recAdmin=dao.findByID(id);
		if(recAdmin.isPresent())
		{
			str.setBody(recAdmin.get());
			str.setMessage("Admin Found");
			str.setCode(HttpStatus.OK.value());
			return new  ResponseEntity<ResponseStructure<Admin>>(str,HttpStatus.ACCEPTED);
			
		}
		 throw new IdNotFoundException();
	}

	public ResponseEntity<ResponseStructure<Admin>> verifyAdmin(long phone, String password) {
		ResponseStructure<Admin> str=new ResponseStructure<>();
		Optional<Admin> recAdmin=dao.verifyAdmin(phone,password);
		if(recAdmin.isPresent())
		{
			str.setBody(recAdmin.get());
			str.setMessage("Admin verified");
			str.setCode(HttpStatus.OK.value());
			return new  ResponseEntity<ResponseStructure<Admin>>(str,HttpStatus.ACCEPTED);
			
		}
		 throw new InvaildCredentialException();
	}

}
