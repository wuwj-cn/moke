package com.moke.cms.dao;

import java.util.List;

import com.moke.cms.model.Dept;

public interface DeptDao {

	public Dept getDept(String id);
	
	public void saveDept(Dept dept);
	
	public void updateDept(Dept dept);
	
	public void removeDept(String id);
	
	public List<Dept> findDeptByParentCode(String parentCode);
}
