package com.tdh.urlInterceptor.provider.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tdh.urlInterceptor.provider.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	UserService userService;

	@RequestMapping("/findUserById")
	public String findUserById(@RequestParam String id) {
		return userService.findUserById(id);
	}

	@RequestMapping("/listUser")
	public String listUser() {
		return userService.listUser();
	}

}
