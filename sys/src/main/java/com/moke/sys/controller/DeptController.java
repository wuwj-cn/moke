package com.moke.sys.controller;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.moke.core.advice.Result;
import com.moke.core.tree.model.CheckboxTreeNode;
import com.moke.core.tree.model.TreeNode;
import com.moke.sys.model.Company;
import com.moke.sys.model.Dept;
import com.moke.sys.service.CompanyService;
import com.moke.sys.service.DeptService;

@RestController
@RequestMapping("/dept")
public class DeptController {
	protected final Log logger = LogFactory.getLog(getClass());
	
	@Autowired
	public DeptService deptService;
	
	@Autowired
	public CompanyService companyService;
	
	@RequestMapping(value = "/get", method= RequestMethod.GET)
	public Result get(@PathVariable String id) {
		Dept dept = deptService.getDept(id);
		return Result.sucess(dept);
	}
	
	@RequestMapping(value="/save", method = RequestMethod.POST)
	public Result saveDept(Dept dept) {
		if(dept.getUuid().isEmpty()) dept.setUuid(null);
		deptService.saveDept(dept);
		return Result.sucess(dept);
	}
	
	@RequestMapping(value="/tree/company", method = RequestMethod.GET)
	public Result getDeptTree() {
		Company company = companyService.getCompany();
		TreeNode root = new TreeNode(company.getCode(), company.getName(), company.getName(), "", "", "", false, false);
		return Result.sucess(root);
	}
	
	@RequestMapping(value="/tree/{deptCode}", method = RequestMethod.GET)
	public Result getDeptTreeByCode(@PathVariable String deptCode) {
		List<TreeNode> nodes = deptService.getDeptTree(deptCode);
		return Result.sucess(nodes);
	}
	
	@RequestMapping(value="/multitree/{deptCode}", method= RequestMethod.GET)
	public Result getDeptMultiTreeByCode(@PathVariable String deptCode){
		List<CheckboxTreeNode> nodes = deptService.getDeptMultiTree(deptCode);
		return Result.sucess(nodes);
	}
	
	@RequestMapping(value="/{deptCode}", method = RequestMethod.POST)
	public Result findDeptByCode(@PathVariable String deptCode) {
		Dept dept = deptService.findDeptByCode(deptCode);
		return Result.sucess(dept);
	}
}
