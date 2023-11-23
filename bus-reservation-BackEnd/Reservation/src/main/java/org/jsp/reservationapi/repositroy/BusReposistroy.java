package org.jsp.reservationapi.repositroy;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.jsp.reservationapi.dto.Bus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BusReposistroy  extends JpaRepository<Bus, Integer>{
	
	@Query("select b from Bus b where b.from=?1 and b.to=?2 and b.dop=?3")
	public List<Bus> filter(String from,String to,LocalDate dop);

}
