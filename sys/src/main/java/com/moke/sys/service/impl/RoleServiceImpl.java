package com.moke.sys.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moke.core.service.impl.BaseServiceImpl;
import com.moke.sys.dao.RoleDao;
import com.moke.sys.model.Role;
import com.moke.sys.service.RoleService;

@Service
public class RoleServiceImpl extends BaseServiceImpl implements RoleService {

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
