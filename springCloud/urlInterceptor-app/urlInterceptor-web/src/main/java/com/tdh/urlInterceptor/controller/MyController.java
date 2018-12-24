package com.tdh.urlInterceptor.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.tdh.urlInterceptor.Application;
import com.tdh.urlInterceptor.service.MyService;

@RestController
@RequestMapping("/test")
public class MyController {
	
	private final Logger logger = LoggerFactory.getLogger(Application.class);
	@Autowired
	private MyService myService;
	
	@RequestMapping("/helloWorld")
	public String helloWorld() {
		Gson gson=new Gson();
		logger.info(gson.toJson(myService.findById(1)));
		return "helloWorld";
	}

}
