package com.moke.sys.service;

import java.util.List;

import com.moke.core.service.Manager;
import com.moke.sys.model.User;

public interface UserManager extends Manager {

	public User getUser(String id);

	public void saveUser(User user);

	public void updateUser(User user);

	public void removeUser(String id);
	
	public List<User> findUsers();
}
