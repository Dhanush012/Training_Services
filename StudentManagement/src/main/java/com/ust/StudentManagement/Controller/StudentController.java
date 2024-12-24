package com.ust.StudentManagement.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ust.StudentManagement.Model.Student;
import com.ust.StudentManagement.Service.StudentService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService service;

    @PostMapping("/addstudent")
    public Mono<Student> addStudent(@RequestBody Student student) {
        return service.addStudent(student);
    }
    
    
    @GetMapping("/all")
    public Flux<Student> getAllStudents() {
        return service.getAllStudents();
    }
    
    @GetMapping("{coursecode}")
    public Flux<Student> getStudent(@PathVariable("coursecode")int coursecode){
    	return service.getStudent(coursecode);
    }
    

}

