package com.moke.sys.dao;

import java.util.List;

import com.moke.core.dao.Dao;
import com.moke.sys.model.User;

public interface UserDao extends Dao {

	public User getUser(String id);

	public void saveUser(User user);

	public void updateUser(User user);

	public void removeUser(String id);
	
	public List<User> findUsers();
}
