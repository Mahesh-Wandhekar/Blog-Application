package com.nt.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nt.Entity.User;

public interface UserRepo extends JpaRepository<User, Integer> {
	
	public User findByEmailAndPassword(String email,String password);

}
