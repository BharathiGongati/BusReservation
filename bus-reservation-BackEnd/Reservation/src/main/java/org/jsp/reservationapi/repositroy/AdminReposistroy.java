package org.jsp.reservationapi.repositroy;

import java.util.Optional;

import org.jsp.reservationapi.dto.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AdminReposistroy  extends JpaRepository<Admin, Integer>{
	
	@Query("select a from Admin a where a.phone=?1 and a.password=?2")
	public Optional<Admin> verifyAdmin(long phone,String password);

}
