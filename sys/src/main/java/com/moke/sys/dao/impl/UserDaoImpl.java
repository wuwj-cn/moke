package com.moke.sys.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.moke.core.dao.hibernate.BaseDaoHibernate;
import com.moke.sys.dao.UserDao;
import com.moke.sys.model.Role;
import com.moke.sys.model.User;

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

	@Override
	public User findByName(String username) {
		String hql = "from User where username = ?";
		List<User> list = this.find(hql, username);
		if(null != list && !list.isEmpty()) return list.get(0);
		return null;
	}

}
