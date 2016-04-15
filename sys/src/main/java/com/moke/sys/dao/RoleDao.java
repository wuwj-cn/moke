package com.moke.sys.dao;

import java.util.List;

import com.moke.core.dao.Dao;
import com.moke.sys.model.Role;

public interface RoleDao extends Dao {

	public Role getRole(String id);

	public void saveRole(Role role);

	public void updateRole(Role role);

	public void removeRole(String id);
	
	public List<Role> findRoles();
}
