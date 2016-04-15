package com.moke.sys.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.moke.core.dao.hibernate.BaseDaoHibernate;
import com.moke.sys.dao.DeptDao;
import com.moke.sys.model.Dept;

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
		String hql = "from Dept where parentCode = ? order by code";
		return this.find(hql, new Object[]{parentCode});
	}
	
	@Override
	public Dept findDeptByCode(String deptCode) {
		String hql = "from Dept where code = ?";
		List<Dept> depts = this.find(hql, new Object[]{deptCode});
		if(null != depts && !depts.isEmpty()) {
			return depts.get(0);
		}
		return null;
	}

}
