package com.moke.cms.controller;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.moke.cms.model.Company;
import com.moke.cms.model.Dept;
import com.moke.cms.service.CompanyManager;
import com.moke.cms.service.DeptManager;
import com.moke.core.advice.Result;
import com.moke.core.tree.model.TreeNode;

@RestController
@RequestMapping("/dept")
public class DeptController {
	protected final Log logger = LogFactory.getLog(getClass());
	
	@Autowired
	public DeptManager deptManager;
	
	@Autowired
	public CompanyManager companyManager;
	
	@RequestMapping(value = "/get", method= RequestMethod.GET)
	public Result get(@PathVariable String id) {
		Dept dept = deptManager.getDept(id);
		return Result.sucess(dept);
	}
	
	@RequestMapping(value="/save", method = RequestMethod.POST)
	public Result saveDept(Dept dept) {
		if(dept.getUuid().isEmpty()) dept.setUuid(null);
		deptManager.saveDept(dept);
		return Result.sucess(dept);
	}
	
	@RequestMapping(value="/tree/company", method = RequestMethod.GET)
	public Result getDeptTree() {
		Company company = companyManager.getCompany();
		TreeNode root = new TreeNode(company.getCode(), company.getName(), company.getName(), "", "", "", false, false);
		return Result.sucess(root);
	}
	
	@RequestMapping(value="/tree/{deptCode}", method = RequestMethod.GET)
	public Result getDeptTreeByCode(@PathVariable String deptCode) {
		List<TreeNode> nodes = deptManager.getDeptTree(deptCode);
		return Result.sucess(nodes);
	}
	
	@RequestMapping(value="/{deptCode}", method = RequestMethod.POST)
	public Result findDeptByCode(@PathVariable String deptCode) {
		Dept dept = deptManager.findDeptByCode(deptCode);
		return Result.sucess(dept);
	}
}
