package com.moke.cms.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.moke.cms.dao.DeptDao;
import com.moke.cms.model.Dept;
import com.moke.core.dao.hibernate.BaseDaoHibernate;

@SuppressWarnings("unchecked")
@Repository
public class DeptDaoImpl extends BaseDaoHibernate implements DeptDao {

	@Override
	public Dept getDept(String id) {
		return (Dept) this.getObject(Dept.class, id);
	}

	@Override
	public void saveDept(Dept dept) {
		this.saveObject(dept);
	}

	@Override
	public void updateDept(Dept dept) {
		this.updateObject(dept);
	}

	@Override
	public void removeDept(String id) {
		this.removeObject(Dept.class, id);
	}

	@Override
	public List<Dept> findDeptByParentCode(String parentCode) {
		String hql = "from Dept where parentCode = ?";
		return this.find(hql, new Object[]{parentCode});
	}

}