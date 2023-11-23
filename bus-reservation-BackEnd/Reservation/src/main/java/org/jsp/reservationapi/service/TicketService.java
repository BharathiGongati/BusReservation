package org.jsp.reservationapi.service;

import java.util.Optional;

import org.jsp.reservationapi.dao.BusDao;
import org.jsp.reservationapi.dao.TicketDao;
import org.jsp.reservationapi.dao.UserDao;
import org.jsp.reservationapi.dto.Bus;
import org.jsp.reservationapi.dto.EmailConfiguration;
import org.jsp.reservationapi.dto.ResponseStructure;
import org.jsp.reservationapi.dto.Ticket;
import org.jsp.reservationapi.dto.User;
import org.jsp.reservationapi.exception.IdNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class TicketService {
	
	@Autowired
	public TicketDao tdao;
	
	@Autowired
	public BusDao bdao;
	
	@Autowired
	public UserDao udao;
	@Autowired
	public EmailConfiguration config;
	@Autowired
	public EmailService service;

	public ResponseEntity<ResponseStructure<Ticket>> saveTicket(Ticket ticket,int bus_id,int user_id) {
		ResponseStructure<Ticket> str=new ResponseStructure<>();
		Optional<Bus> busdata=bdao.findById(bus_id);
		Optional<User> userdata=udao.findById(user_id);
		if(busdata.isPresent() && userdata.isPresent())
		{
			Bus b=busdata.get();
			User u=userdata.get();
			b.getTickets().add(ticket);
			u.getTickets().add(ticket);
			ticket.setCost(ticket.getNumber_of_seats()* busdata.get().getCost_per_seat());
			ticket.setBus(busdata.get());
			ticket.setUser(userdata.get() );
			config.setTo(u.getEmail());
			config.setSubject("cinfirmed on ticket Booking");
			config.setText("Dear passender "+u.getName()+"/n"+ "number of seats booked" +ticket.getNumber_of_seats()+ "/n"+"seat numbers"+ticket.getSeat_no()+"/n"+
			b.getBus_no()+"/n"+"Thank You");
			String message=service.sendEmail(config);
			bdao.updateBus(busdata.get());
			udao.updateUser(userdata.get());
		   str.setBody(tdao.saveTicket(ticket));
		   str.setMessage(message);
		   str.setCode(HttpStatus.CREATED.value());
		   return new ResponseEntity<ResponseStructure<Ticket>>(str,HttpStatus.CREATED);
		}
		throw new IdNotFoundException();
		
	}
	public ResponseEntity<ResponseStructure<Ticket>> updateTicket(Ticket ticket,int bus_id,int user_id) {
		ResponseStructure<Ticket> str=new ResponseStructure<>();
		Optional<Bus> busdata=bdao.findById(bus_id);
		Optional<User> userdata=udao.findById(user_id);
		if(busdata.isPresent() && userdata.isPresent())
		{
			Bus b=busdata.get();
			User u=userdata.get();
			ticket.setCost(ticket.getNumber_of_seats()* busdata.get().getCost_per_seat());
			ticket.setBus(busdata.get());
			ticket.setUser(userdata.get() );
			config.setTo(u.getEmail());
			config.setSubject("updated on ticket Booking");
			config.setText("Dear passender "+u.getName()+"/n"+ "number of seats booked" +ticket.getNumber_of_seats()+ "/n"+"seat numbers"+ticket.getSeat_no()+"/n"+
			b.getBus_no()+"/n"+"Thank You");
			String message=service.sendEmail(config);
			bdao.updateBus(busdata.get());
			udao.updateUser(userdata.get());
		   str.setBody(tdao.saveTicket(ticket));
		   str.setMessage(message);
		   str.setCode(HttpStatus.CREATED.value());
		   return new ResponseEntity<ResponseStructure<Ticket>>(str,HttpStatus.CREATED);
		}
		throw new IdNotFoundException();
		
	}
	
	public ResponseEntity<ResponseStructure<String>> deleteTicket(int id)
	{
		ResponseStructure<String> str=new ResponseStructure<>();
		Optional<Ticket> recticket=tdao.findById(id);
		if(recticket.isEmpty())
		{
			throw new IdNotFoundException();
		}
		User u=recticket.get().getUser();
		Bus b=recticket.get().getBus();
		Ticket ticket=recticket.get();
		tdao.deleteTicket(recticket.get());
		config.setTo(u.getEmail());
		config.setSubject("Deleted your ticket");
		config.setText("Dear passender "+u.getName()+"/n"+ "number of seats booked" +ticket.getNumber_of_seats()+ "/n"+"seat numbers"+ticket.getSeat_no()+"/n"+
		b.getBus_no()+"/n"+"Thank You");
		String message=service.sendEmail(config);
		str.setBody("Booking has been cancelled");
		str.setMessage(message);
		str.setCode(HttpStatus.OK.value());;
		
		return new ResponseEntity<ResponseStructure<String>>(str,HttpStatus.OK);
	}


	

}
