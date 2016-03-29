package com.moke.cms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.moke.cms.model.User;
import com.moke.cms.service.UserManager;
import com.moke.core.advice.Result;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	public UserManager userManager;
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public Result saveRole(User user) {
		if(user.getUuid().isEmpty()) user.setUuid(null);
		userManager.saveUser(user);
		return Result.sucess(user);
	}
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public Result findRoles() {
		List<User> users = userManager.findUsers();
		return Result.sucess(users);
	}
}
