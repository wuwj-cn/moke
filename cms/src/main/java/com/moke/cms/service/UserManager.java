package com.moke.cms.service;

import java.util.List;

import com.moke.cms.model.User;
import com.moke.core.service.Manager;

public interface UserManager extends Manager {

	public User getUser(String id);

	public void saveUser(User user);

	public void updateUser(User user);

	public void removeUser(String id);
	
	public List<User> findUsers();
}
