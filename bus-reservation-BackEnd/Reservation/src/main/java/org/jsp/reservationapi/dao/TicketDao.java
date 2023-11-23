package org.jsp.reservationapi.dao;

import java.util.Optional;

import org.jsp.reservationapi.dto.Ticket;
import org.jsp.reservationapi.repositroy.TicketRepositroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class TicketDao {
	
	@Autowired
	public TicketRepositroy repo;
	
	public Ticket saveTicket(Ticket ticket) {
		return repo.save(ticket);
	}
	
	public Ticket updateTicket(Ticket ticket) {
		return repo.save(ticket);
	}
	public Optional<Ticket> findById(int id) 
	{
		return repo.findById(id);
	}
	public void deleteTicket(Ticket ticket)
	{
		repo.delete(ticket);
	}
	
//	public Optional<Ticket> verifyByPhone(String email,String password)
//	{
//		return repo.verifyByPhone(email, password);
//	}

}
