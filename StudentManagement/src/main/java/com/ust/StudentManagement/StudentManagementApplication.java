package com.ust.StudentManagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@EnableMongoRepositories(basePackages = "com.ust.StudentManagement.Repository")
//@ComponentScan(basePackages = {"com.ust.StudentManagement.Repository", "com.ust.StudentManagement.Service"})
public class StudentManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentManagementApplication.class, args);
	}

}
