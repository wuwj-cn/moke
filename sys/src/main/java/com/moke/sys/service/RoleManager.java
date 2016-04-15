package com.moke.sys.service;

import java.util.List;

import com.moke.core.service.Manager;
import com.moke.sys.model.Role;

public interface RoleManager extends Manager {

	public Role getRole(String id);

	public void saveRole(Role role);

	public void updateRole(Role role);

	public void removeRole(String id);
	
	public List<Role> findRoles();
}
