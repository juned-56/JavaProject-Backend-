package com.prc.ss.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prc.ss.model.User;
import com.prc.ss.repository.UserRepository;

@Service
@Transactional
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public User addNewUser(User usr) {
		return userRepository.save(usr);
	}

	@Override
	public void deleteUser(int id) {
		userRepository.deleteById(id);
	}

}
