package com.moke.cms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moke.cms.dao.RoleDao;
import com.moke.cms.model.Role;
import com.moke.cms.service.RoleManager;
import com.moke.core.service.impl.BaseManager;

@Service
public class RoleManagerImpl extends BaseManager implements RoleManager {

	@Autowired
	public RoleDao roleDao;
	
	@Override
	public Role getRole(String id) {
		return roleDao.getRole(id);
	}

	@Override
	public void saveRole(Role role) {
		roleDao.saveRole(role);;
	}

	@Override
	public void updateRole(Role role) {
		roleDao.updateRole(role);
	}

	@Override
	public void removeRole(String id) {
		roleDao.removeRole(id);
	}

	@Override
	public List<Role> findRoles() {
		return roleDao.findRoles();
	}

}
