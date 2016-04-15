package com.moke.sys.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.moke.core.dao.hibernate.BaseDaoHibernate;
import com.moke.sys.dao.RoleDao;
import com.moke.sys.model.Role;

@SuppressWarnings("unchecked")
@Repository
public class RoleDaoImpl extends BaseDaoHibernate implements RoleDao {

	@Override
	public Role getRole(String id) {
		return (Role) this.getObject(Role.class, id);
	}

	@Override
	public void saveRole(Role role) {
		this.saveObject(role);
	}

	@Override
	public void updateRole(Role role) {
		this.updateObject(role);
	}

	@Override
	public void removeRole(String id) {
		this.removeObject(Role.class, id);
	}

	@Override
	public List<Role> findRoles() {
		return this.getObjects(Role.class);
	}

}
