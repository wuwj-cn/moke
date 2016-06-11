package com.moke.sys.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moke.core.service.impl.BaseServiceImpl;
import com.moke.core.tree.model.CheckboxTreeNode;
import com.moke.core.tree.model.TreeNode;
import com.moke.sys.dao.DeptDao;
import com.moke.sys.model.Dept;
import com.moke.sys.service.DeptService;

@Service
public class DeptServiceImpl extends BaseServiceImpl implements DeptService {

	@Autowired
	public DeptDao deptDao;
	
	@Override
	public Dept getDept(String id) {
		return deptDao.getDept(id);
	}

	@Override
	public void saveDept(Dept dept) {
		deptDao.saveDept(dept);
	}

	@Override
	public void updateDept(Dept dept) {
		deptDao.updateDept(dept);
	}

	@Override
	public void removeDept(String id) {
		deptDao.removeDept(id);
	}

	public List<TreeNode> getDeptTree(String parentCode) {
		List<Dept> depts = deptDao.findDeptByParentCode(parentCode);
		List<TreeNode> nodes = new ArrayList<TreeNode>();
		for(Dept dept : depts) {
			nodes.add(new TreeNode(dept.getCode(), dept.getName(), dept.getName(), "", "", "", false, false));
		}
		return nodes;
	}
	
	public List<CheckboxTreeNode> getDeptMultiTree(String parentCode) {
		List<Dept> depts = deptDao.findDeptByParentCode(parentCode);
		List<CheckboxTreeNode> nodes = new ArrayList<CheckboxTreeNode>();
		for(Dept dept : depts) {
			nodes.add(new CheckboxTreeNode(dept.getCode(), dept.getName(), dept.getName(), "", "", "", false, false, false));
		}
		return nodes;
	}
	
	public Dept findDeptByCode(String deptCode) {
		return deptDao.findDeptByCode(deptCode);
	}
}
