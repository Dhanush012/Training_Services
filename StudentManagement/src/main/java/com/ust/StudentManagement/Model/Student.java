package com.ust.StudentManagement.Model;

import java.util.List;
import java.util.Map;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
//
@Document
public class Student {
	
	@Id
	private int studentId;
	private String studentName;
	private int AttendencePercentage;
	private String email;
	private int courseCode;
	private List<Map<String,Integer>> marks;
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public int getAttendencePercentage() {
		return AttendencePercentage;
	}
	public void setAttendencePercentage(int attendencePercentage) {
		AttendencePercentage = attendencePercentage;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getCourseCode() {
		return courseCode;
	}
	public void setCourseCode(int courseCode) {
		this.courseCode = courseCode;
	}
	public List<Map<String, Integer>> getMarks() {
		return marks;
	}
	public void setMarks(List<Map<String, Integer>> marks) {
		this.marks = marks;
	}
	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", studentName=" + studentName + ", AttendencePercentage="
				+ AttendencePercentage + ", email=" + email + ", courseCode=" + courseCode + ", marks=" + marks + "]";
	}
	public Student(int studentId, String studentName, int attendencePercentage, String email, int courseCode,
			List<Map<String, Integer>> marks) {
		super();
		this.studentId = studentId;
		this.studentName = studentName;
		AttendencePercentage = attendencePercentage;
		this.email = email;
		this.courseCode = courseCode;
		this.marks = marks;
	}
	public Student() {
		super();
	}
	
	
	
}
