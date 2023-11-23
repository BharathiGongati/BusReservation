package org.jsp.reservationapi.controller;

import org.jsp.reservationapi.dto.ResponseStructure;
import org.jsp.reservationapi.dto.Ticket;
import org.jsp.reservationapi.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TicketController {
	
	@Autowired
	public TicketService ticketvice;
	
	@PostMapping(value = "/ticket/{bus_id}/{user_id}")
	public ResponseEntity<ResponseStructure<Ticket>> saveTicket(@RequestBody Ticket ticket,@PathVariable int bus_id ,@PathVariable int user_id)
	{
		return ticketvice.saveTicket(ticket,bus_id,user_id);
	}
	@PutMapping(value = "/ticket/{bus_id}/{user_id}")
	public ResponseEntity<ResponseStructure<Ticket>> updateTicket(@RequestBody Ticket ticket,@PathVariable int bus_id ,@PathVariable int user_id)
	{
		return ticketvice.updateTicket(ticket,bus_id,user_id);
	}
	
	@DeleteMapping(value = "/ticket/{id}")
	public ResponseEntity<ResponseStructure<String>> booki(@PathVariable int id)
	{
		return ticketvice.deleteTicket(id);
	}
	

}
