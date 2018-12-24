package com.tdh.urlInterceptor;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.google.gson.Gson;
import com.tdh.urlInterceptor.service.StudentService;

/**
 * Unit test for simple App.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
public class AppTest {

	private final Logger log = LoggerFactory.getLogger(AppTest.class);

	@Autowired
	StudentService studentService;

	@Test
	public void findById() {
		Gson gson = new Gson();
		log.info("结果"+gson.toJson(studentService.selectByPrimaryKey(1)));
	}

}
