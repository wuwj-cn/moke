package com.moke.cms.service;

import java.util.List;

import com.moke.cms.model.Dept;
import com.moke.core.tree.model.TreeNode;

public interface DeptManager {

	public Dept getDept(String id);
	
	public void saveDept(Dept dept);
	
	public void updateDept(Dept dept);
	
	public void removeDept(String id);
	
	public List<TreeNode> getDeptTree(String parentCode);
}