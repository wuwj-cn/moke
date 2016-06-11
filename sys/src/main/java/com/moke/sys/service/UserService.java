package com.moke.sys.service;

import java.util.List;
import java.util.Set;

import com.moke.core.service.BaseService;
import com.moke.sys.model.User;

public interface UserService extends BaseService {

	public User getUser(String id);

	public void saveUser(User user);

	public void updateUser(User user);

	public void removeUser(String id);
	
	public List<User> findUsers();
	
	public Set<String> findRoles(String username);
	
	public Set<String> findPermissions(String username);
	
	public User findByName(String username);
}
