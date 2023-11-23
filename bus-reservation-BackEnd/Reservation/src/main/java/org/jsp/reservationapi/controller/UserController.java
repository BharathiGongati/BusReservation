package org.jsp.reservationapi.controller;

import org.jsp.reservationapi.dto.ResponseStructure;
import org.jsp.reservationapi.dto.User;
import org.jsp.reservationapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class UserController {
	
	@Autowired
	public UserService uservice;
	
	@PostMapping(value = "/user")
	public ResponseEntity<ResponseStructure<User>> saveUser(@RequestBody User user)
	{
		return uservice.saveUser(user);
	}
	
	@PutMapping(value = "/user")
	public ResponseEntity<ResponseStructure<User>> updateUser(@RequestBody User user)
	{
		return uservice.updateUser(user);
	}
	@GetMapping(value = "/user/{id}")
	public ResponseEntity<ResponseStructure<User>> findById(@PathVariable int id)
	{
		return uservice.findById(id);
	}
	@PostMapping(value = "/user/verify-by-phone")
	public ResponseEntity<ResponseStructure<User>> verifyByPhone(@RequestParam String email,@RequestParam String password)
	{
		return uservice.verifyByPhone(email, password);
	}
	


}
