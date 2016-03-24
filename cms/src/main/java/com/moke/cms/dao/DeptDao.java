package com.moke.cms.dao;

import java.util.List;

import com.moke.cms.model.Dept;
import com.moke.core.dao.Dao;

public interface DeptDao extends Dao{

	public Dept getDept(String id);
	
	public void saveDept(Dept dept);
	
	public void updateDept(Dept dept);
	
	public void removeDept(String id);
	
	public List<Dept> findDeptByParentCode(String parentCode);
	
	public Dept findDeptByCode(String deptCode);
}
