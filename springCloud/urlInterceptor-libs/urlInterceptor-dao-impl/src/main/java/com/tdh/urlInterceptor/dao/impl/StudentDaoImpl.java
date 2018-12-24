package com.tdh.urlInterceptor.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.tdh.urlInterceptor.dao.StudentDao;
import com.tdh.urlInterceptor.mapper.StudentMapper;
import com.tdh.urlInterceptor.model.Student;

@Repository
@Transactional
public class StudentDaoImpl implements StudentDao {

	@Autowired
	private StudentMapper studentMapper;

	@Override
	public int deleteByPrimaryKey(long uid) {
		return studentMapper.deleteByPrimaryKey(uid);
	}

	@Override
	public int insert(Student record) {
		return studentMapper.insert(record);
	}

	@Override
	public int insertSelective(Student record) {
		return studentMapper.insertSelective(record);
	}

	@Override
	public Student selectByPrimaryKey(long uid) {
		return studentMapper.selectByPrimaryKey(uid);
	}

	@Override
	public List<Student> selectByCondition(Student record) {
		return studentMapper.selectByCondition(record);
	}

	@Override
	public int updateByPrimaryKeySelective(Student record) {
		return studentMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(Student record) {
		return studentMapper.updateByPrimaryKey(record);
	}

}
