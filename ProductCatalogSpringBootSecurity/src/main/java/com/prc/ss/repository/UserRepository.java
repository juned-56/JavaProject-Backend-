package com.prc.ss.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prc.ss.model.User;

public interface UserRepository extends JpaRepository<User, Integer>{
	public User findByNameContaining(String username);

	//public User save(User user, boolean b);
}
