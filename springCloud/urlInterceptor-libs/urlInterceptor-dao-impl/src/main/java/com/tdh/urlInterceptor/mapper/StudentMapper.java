package com.tdh.urlInterceptor.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.tdh.urlInterceptor.model.Student;

@Mapper
public interface StudentMapper {
    int deleteByPrimaryKey(long uid);

    int insert(Student record);

    int insertSelective(Student record);

    Student selectByPrimaryKey(long uid);

    List<Student> selectByCondition(Student record);

    int updateByPrimaryKeySelective(Student record);

    int updateByPrimaryKey(Student record);
}