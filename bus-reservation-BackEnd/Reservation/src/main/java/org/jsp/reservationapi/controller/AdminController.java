package org.jsp.reservationapi.controller;

import org.jsp.reservationapi.dto.Admin;
import org.jsp.reservationapi.dto.ResponseStructure;
import org.jsp.reservationapi.service.AdminService;
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
public class AdminController {
	
	@Autowired
	public AdminService service;
	
	@PostMapping(value = "/admins")
	public ResponseEntity<ResponseStructure<Admin>> saveAdmin(@RequestBody Admin admin)
	{
		return service.saveAdmin(admin);
	}
	@PutMapping(value = "/admins")
	public ResponseEntity<ResponseStructure<Admin>> updateAdmin(@RequestBody Admin admin)
	{
		return service.updateAdmin(admin);
	}
	@GetMapping(value = "/admins/{id}")
	public ResponseEntity<ResponseStructure<Admin>> findById(@PathVariable int id)
	{
		return service.findById(id);
	}
	@PostMapping(value = "/admins/verify-by-phone")
	public ResponseEntity<ResponseStructure<Admin>> verifyAdmin(@RequestParam long phone,@RequestParam String password )
	{
		return service.verifyAdmin(phone,password);
	}

}
