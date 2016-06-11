package com.moke.sys.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.moke.core.advice.Result;
import com.moke.sys.model.User;
import com.moke.sys.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	public UserService userService;
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public Result saveRole(User user) {
		if(user.getUuid().isEmpty()) user.setUuid(null);
		userService.saveUser(user);
		return Result.sucess(user);
	}
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public Result findRoles() {
		List<User> users = userService.findUsers();
		return Result.sucess(users);
	}
}
