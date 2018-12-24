package com.tdh.urlInterceptor.consumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.tdh.urlInterceptor.consumer.remote.StudentRemote;
import com.tdh.urlInterceptor.model.Student;

@RestController
public class StudentController {

	@Autowired
	RestTemplate template;
	@Autowired
	StudentRemote studentRemote;

	@RequestMapping("/findById")
	public String findById(@RequestParam String id) {
		Student student=new Student();
		student.setUid(1L);
//		return template.postForObject("http://provider-message/findStudent", student, String.class);
		return studentRemote.findById(student);
	}

	@RequestMapping("/helloWorld")
	public String helloWorld() {
//		return template.getForObject("http://provider-message/helloWorld", String.class);
		return studentRemote.helloWorld();
	}
}
