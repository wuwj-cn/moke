package com.moke.cms.service;

import java.util.List;

import com.moke.cms.model.Role;
import com.moke.core.service.Manager;

public interface RoleManager extends Manager {

	public Role getRole(String id);

	public void saveRole(Role role);

	public void updateRole(Role role);

	public void removeRole(String id);
	
	public List<Role> findRoles();
}
