package com.tdh.urlInterceptor.service;

import java.util.List;

import com.tdh.urlInterceptor.model.Student;

public interface StudentService {
    int deleteByPrimaryKey(long uid);

    int insert(Student record);

    int insertSelective(Student record);

    Student selectByPrimaryKey(long uid);

    List<Student> selectByCondition(Student record);

    int updateByPrimaryKeySelective(Student record);

    int updateByPrimaryKey(Student record);
}
