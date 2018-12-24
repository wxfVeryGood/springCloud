package com.tdh.urlInterceptor.provider01.service.impl;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

import com.tdh.urlInterceptor.provider01.service.UserService;

@Component
public class UserServiceImpl implements UserService {

	@Override
	public String findUserById(@RequestParam(value="1",required = true) String id) {
		return "This is failure findUserById of urlInterceptor provider";
	}

	@Override
	public String listUser() {
		return "This is failure listUser of urlInterceptor provider";
	}

}
