package com.tdh.urlInterceptor.mongodb.repository;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.QueryByExampleExecutor;

import com.tdh.urlInterceptor.model.Student;

/**
 * 
 * @ClassName: StudentRepository
 * @Description: (学生持久层接口类)
 * @author wxf
 * @date 2018年11月21日 下午6:10:28
 *
 */
public interface StudentRepository extends MongoRepository<Student, ObjectId>, QueryByExampleExecutor<Student> {

	List<Student> findByName(String name);

	@Query("{'uid':?0}")
	Student findById(Long id);
}
