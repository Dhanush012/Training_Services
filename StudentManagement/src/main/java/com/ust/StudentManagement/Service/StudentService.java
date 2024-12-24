package com.ust.StudentManagement.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import reactor.core.publisher.Flux;

import com.ust.StudentManagement.Model.Student;
import com.ust.StudentManagement.Repository.StudentRepo;

@Service
public class StudentService {

    @Autowired
    private StudentRepo repo;

    // Using Mono<Student> for a single student
    public Mono<Student> addStudent(Student student) {
        return repo.save(student);
    }

    // Using Flux<Student> for multiple students
    public Flux<Student> getAllStudents() {
        return repo.findAll();
    }

	public Flux<Student> getStudent(int coursecode) {
		return repo.findByCourseCode(coursecode);
	}
}
