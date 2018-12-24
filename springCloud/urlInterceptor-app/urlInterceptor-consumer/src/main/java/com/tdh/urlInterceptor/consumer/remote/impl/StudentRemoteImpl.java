package com.tdh.urlInterceptor.consumer.remote.impl;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

import com.tdh.urlInterceptor.consumer.remote.StudentRemote;
import com.tdh.urlInterceptor.model.Student;

@Component
public class StudentRemoteImpl implements StudentRemote {

	@Override
	public String findById(@RequestBody Student student) {
		return "This is failure findById of urlInterceptor-consumer ";
	}

	@Override
	public String helloWorld() {
		return "This is failure helloWorld of urlInterceptor-consumer ";
	}

}
