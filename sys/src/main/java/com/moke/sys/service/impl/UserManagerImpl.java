package com.moke.sys.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moke.core.service.impl.BaseManager;
import com.moke.sys.dao.UserDao;
import com.moke.sys.model.User;
import com.moke.sys.service.UserManager;

@Service
public class UserManagerImpl extends BaseManager implements UserManager {

	@Autowired
	public UserDao userDao;
	
	@Override
	public User getUser(String id) {
		return userDao.getUser(id);
	}

	@Override
	public void saveUser(User user) {
		userDao.saveUser(user);;
	}

	@Override
	public void updateUser(User user) {
		userDao.updateUser(user);
	}

	@Override
	public void removeUser(String id) {
		userDao.removeUser(id);
	}

	@Override
	public List<User> findUsers() {
		return userDao.findUsers();
	}

}
