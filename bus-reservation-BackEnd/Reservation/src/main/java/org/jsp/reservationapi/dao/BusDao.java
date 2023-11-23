package org.jsp.reservationapi.dao;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.jsp.reservationapi.dto.Bus;
import org.jsp.reservationapi.repositroy.BusReposistroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BusDao {
	@Autowired
	
	public BusReposistroy brepo;
	
	public Bus saveBus(Bus bus)
	{
		return brepo.save(bus);
	}
	public Bus updateBus(Bus bus) {
		return brepo.save(bus);
	}
	public Optional<Bus> findById(int id) 
	{
		return brepo.findById(id);
	}
	
    public List<Bus> filter(String from,String to,LocalDate dop)
    {
    	return brepo.filter(from,to,dop);
    }

}
