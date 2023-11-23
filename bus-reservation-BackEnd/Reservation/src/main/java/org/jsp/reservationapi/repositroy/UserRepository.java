package org.jsp.reservationapi.repositroy;

import java.util.Optional;

import org.jsp.reservationapi.dto.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository  extends JpaRepository<User, Integer>{
	
	@Query("Select u from User u where u.email=?1 and u.password=?2")
	public Optional<User> verifyByPhone(String email,String password);

}
