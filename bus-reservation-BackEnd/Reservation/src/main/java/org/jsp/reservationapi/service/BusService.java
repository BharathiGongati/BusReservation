package org.jsp.reservationapi.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.jsp.reservationapi.dao.AdminDao;
import org.jsp.reservationapi.dao.BusDao;
import org.jsp.reservationapi.dto.Admin;
import org.jsp.reservationapi.dto.Bus;
import org.jsp.reservationapi.dto.ResponseStructure;
import org.jsp.reservationapi.exception.IdNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class BusService {
	
	@Autowired
	public BusDao bdao;
	
	@Autowired
	public AdminDao adao;
	public ResponseEntity<ResponseStructure<Bus>> saveBus(Bus bus,int admin_id)
	{
		ResponseStructure<Bus> str=new ResponseStructure<>();
		Optional<Admin> recdata=adao.findByID(admin_id);
		if(recdata.isPresent())
		{
			Admin a=recdata.get();
			a.getBuses().add(bus);
			recdata.get().getBuses().add(bus);
			bus.setAdmin(a);
			adao.updateAdmin(a);
			bdao.saveBus(bus);
			
			str.setBody(bus);
			str.setMessage("bus Added");
			str.setCode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<Bus>>(str,HttpStatus.ACCEPTED);
			
		}
		throw new IdNotFoundException();
	}
	public ResponseEntity<ResponseStructure<List<Bus>>> filter(String from, String to, LocalDate dop) {
		ResponseStructure<List<Bus>> str=new ResponseStructure<>();
		
		     str.setBody(bdao.filter(from, to, dop));
		     str.setMessage("List of bues");
		     str.setCode(HttpStatus.OK.value());
		     return new  ResponseEntity<ResponseStructure<List<Bus>>>(str, HttpStatus.OK);
		
	}
	
	
	
	
}
