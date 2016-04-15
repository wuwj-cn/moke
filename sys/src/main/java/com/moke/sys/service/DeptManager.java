package com.moke.sys.service;

import java.util.List;

import com.moke.core.service.Manager;
import com.moke.core.tree.model.CheckboxTreeNode;
import com.moke.core.tree.model.TreeNode;
import com.moke.sys.model.Dept;

public interface DeptManager extends Manager {

	public Dept getDept(String id);
	
	public void saveDept(Dept dept);
	
	public void updateDept(Dept dept);
	
	public void removeDept(String id);
	
	public List<TreeNode> getDeptTree(String parentCode);
	
	public List<CheckboxTreeNode> getDeptMultiTree(String parentCode);
	
	public Dept findDeptByCode(String deptCode);
}
