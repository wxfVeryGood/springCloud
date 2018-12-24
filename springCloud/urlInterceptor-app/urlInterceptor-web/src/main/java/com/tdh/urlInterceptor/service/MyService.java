package com.tdh.urlInterceptor.service;

import org.springframework.stereotype.Service;

import com.alibaba.dubbo.config.annotation.Reference;
import com.google.gson.Gson;
import com.tdh.urlInterceptor.model.Student;

@Service
public class MyService {

	@Reference
	private RedisService redisService;

	@Reference
	private StudentService studentService;

	public Student findById(long id) {
		Student student = studentService.selectByPrimaryKey(id);
		Gson gson = new Gson();
		redisService.set("Student", gson.toJson(student));
		return student;
	}

}
