package com.tdh.urlInterceptor.provider.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.tdh.urlInterceptor.model.Student;
import com.tdh.urlInterceptor.service.StudentService;

/**
 * 
 * @ClassName: StudentController
 * @Description: (学生控制器类)
 * @author wxf
 * @date 2018年11月26日 下午1:17:11
 *
 */
@RestController
public class StudentController {

	private final Logger logger = LoggerFactory.getLogger(StudentController.class);

	@Autowired
	StudentService studentService;

	@RequestMapping("/findStudent")
	public String findStudent(@RequestBody Student student) {
		logger.info("入参id:" + student.getUid());
		Gson gson = new Gson();
		try {
			Thread.sleep(10000000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return gson.toJson(studentService.selectByPrimaryKey(student.getUid() == null ? 1 : student.getUid()));
	}

	@RequestMapping("/helloWorld")
	public String helloWorld() {
		return "This helloWorld of urlInterceptor provider";
	}

}
