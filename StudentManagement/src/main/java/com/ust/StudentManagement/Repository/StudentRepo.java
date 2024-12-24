package com.ust.StudentManagement.Repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.ust.StudentManagement.Model.Student;

import reactor.core.publisher.Flux;



@Repository
public interface StudentRepo extends ReactiveMongoRepository<Student,Integer> {

	Flux<Student> findByCourseCode(int coursecode);
}
