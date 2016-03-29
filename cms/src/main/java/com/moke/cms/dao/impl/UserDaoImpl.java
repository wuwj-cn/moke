package com.moke.cms.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.moke.cms.dao.UserDao;
import com.moke.cms.model.Role;
import com.moke.cms.model.User;
import com.moke.core.dao.hibernate.BaseDaoHibernate;

@SuppressWarnings("unchecked")
@Repository
public class UserDaoImpl extends BaseDaoHibernate implements UserDao {

	@Override
	public User getUser(String id) {
		return (User) this.getObject(Role.class, id);
	}

	@Override
	public void saveUser(User user) {
		this.saveObject(user);
	}

	@Override
	public void updateUser(User user) {
		this.updateObject(user);
	}

	@Override
	public void removeUser(String id) {
		this.removeObject(User.class, id);
	}

	@Override
	public List<User> findUsers() {
		return this.getObjects(User.class);
	}

}
