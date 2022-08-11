package com.prc.ss.service;

import com.prc.ss.model.User;

public interface UserService {
	public User addNewUser(User usr);
	public void deleteUser(int id);
}
