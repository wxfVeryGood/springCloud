package com.tdh.urlInterceptor.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.tdh.urlInterceptor.dao.StudentDao;
import com.tdh.urlInterceptor.model.Student;
import com.tdh.urlInterceptor.mongodb.repository.StudentRepository;
import com.tdh.urlInterceptor.service.StudentService;

//@Service
@org.springframework.stereotype.Service
public class StudentServiceImpl implements StudentService {
	@Autowired
	private StudentDao studentDao;
	@Autowired
	private StudentRepository studentRepository;

	@Override
	public int deleteByPrimaryKey(long uid) {
		return studentDao.deleteByPrimaryKey(uid);
	}

	@Override
	public int insert(Student record) {
		return studentDao.insert(record);
	}

	@Override
	public int insertSelective(Student record) {
		return studentDao.insertSelective(record);
	}

	@Override
	public Student selectByPrimaryKey(long uid) {
//        return studentDao.selectByPrimaryKey(uid);
		Student student = new Student();
		student.setUid(uid);
//		ExampleMatcher matcher = ExampleMatcher.matching()
//				.withMatcher("uid", ExampleMatcher.GenericPropertyMatchers.contains());
//		Example<Student> example = Example.of(student, matcher);
		return studentRepository.findById(uid);
//		return studentRepository.findByUid(uid);
//    	return studentRepository.findOne(new ObjectId("5bf53316b4e831e2e88882b5"));
	}

	@Override
	public List<Student> selectByCondition(Student record) {
		return studentDao.selectByCondition(record);
	}

	@Override
	public int updateByPrimaryKeySelective(Student record) {
		return studentDao.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(Student record) {
		return studentDao.updateByPrimaryKey(record);
	}
}
