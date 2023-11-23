package org.jsp.reservationapi.dao;

import java.util.Optional;

import org.jsp.reservationapi.dto.Admin;
import org.jsp.reservationapi.repositroy.AdminReposistroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AdminDao {
	@Autowired
	AdminReposistroy repo;

	 public Admin saveAdmin(Admin admin)
	 {
		 return repo.save(admin);
	 }
	 public Admin updateAdmin(Admin admin)
	 {
		 return repo.save(admin);
	 }
	
	 public  Optional<Admin> findByID(int id)
	 {
		 return repo.findById(id);
	 }
	public Optional<Admin> verifyAdmin(long phone, String password) {
		return repo.verifyAdmin(phone, password);
	}
}
