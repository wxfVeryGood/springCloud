package com.tdh.urlInterceptor.provider.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tdh.urlInterceptor.provider.service.impl.UserServiceImpl;

@FeignClient(name = "urlInterceptor-consumer", fallback = UserServiceImpl.class)
public interface UserService {

	@RequestMapping("/findUserById")
	public String findUserById(@RequestParam(value="1",required = true) String id);

	@RequestMapping("/listUser")
	public String listUser();

}
