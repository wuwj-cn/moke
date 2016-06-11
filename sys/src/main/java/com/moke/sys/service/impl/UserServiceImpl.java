package com.moke.sys.service.impl;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moke.core.service.impl.BaseServiceImpl;
import com.moke.sys.dao.UserDao;
import com.moke.sys.model.User;
import com.moke.sys.service.UserService;

@Service(value="userService")
public class UserServiceImpl extends BaseServiceImpl implements UserService {

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

	@Override
	public Set<String> findRoles(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<String> findPermissions(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User findByName(String username) {
		return userDao.findByName(username);
	}

}
