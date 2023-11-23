package org.jsp.reservationapi.dao;

import java.util.Optional;

import org.jsp.reservationapi.dto.User;
import org.jsp.reservationapi.repositroy.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao {

	@Autowired
	public UserRepository repo;
	public User saveUser(User user) {
		return repo.save(user);
	}
	public User updateUser(User user) {
		return repo.save(user);
	}
	public Optional<User> findById(int id) 
	{
		return repo.findById(id);
	}
	
	public Optional<User> verifyByPhone(String email,String password)
	{
		return repo.verifyByPhone(email, password);
	}

}
