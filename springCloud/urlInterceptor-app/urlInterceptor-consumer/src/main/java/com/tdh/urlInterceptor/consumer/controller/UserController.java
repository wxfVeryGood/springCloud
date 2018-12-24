package com.tdh.urlInterceptor.consumer.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

	@RequestMapping("/findUserById")
	public String findUserById(@RequestParam String id) {
		try {
			Thread.sleep(10000000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return "This is findUserById urlInterceptor-consumer";
	}

	@RequestMapping("/listUser")
	public String listUser() {
		return "This is listUser urlInterceptor-consumer";
	}

}
