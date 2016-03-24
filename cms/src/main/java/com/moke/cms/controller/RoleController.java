package com.moke.cms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.moke.cms.model.Role;
import com.moke.cms.service.RoleManager;
import com.moke.core.advice.Result;

@RestController
@RequestMapping("/role")
public class RoleController {

	@Autowired
	public RoleManager roleManager;
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public Result saveRole(Role role) {
		if(role.getUuid().isEmpty()) role.setUuid(null);
		roleManager.saveRole(role);
		return Result.sucess(role);
	}
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public Result findRoles() {
		List<Role> roles = roleManager.findRoles();
		return Result.sucess(roles);
	}
}
