package com.moke.sys.dao;

import java.util.List;

import com.moke.core.dao.Dao;
import com.moke.sys.model.Dept;

public interface DeptDao extends Dao{

	public Dept getDept(String id);
	
	public void saveDept(Dept dept);
	
	public void updateDept(Dept dept);
	
	public void removeDept(String id);
	
	public List<Dept> findDeptByParentCode(String parentCode);
	
	public Dept findDeptByCode(String deptCode);
}
