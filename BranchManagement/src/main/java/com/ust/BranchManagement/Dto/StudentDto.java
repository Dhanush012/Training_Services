package com.ust.BranchManagement.Dto;

import java.util.List;
import java.util.Map;

public class StudentDto {
	
	private int studentId;
	private String studentName;
	private int AttendencePercentage;
	private String email;
	private int courseCode;
	private List<Map<String,Integer>> marks;
	
	
	
	public StudentDto(int studentId, String studentName, int attendencePercentage, String email, int courseCode,
			List<Map<String, Integer>> marks) {
		super();
		this.studentId = studentId;
		this.studentName = studentName;
		AttendencePercentage = attendencePercentage;
		this.email = email;
		this.courseCode = courseCode;
		this.marks = marks;
	}



	@Override
	public String toString() {
		return "StudentDto [studentId=" + studentId + ", studentName=" + studentName + ", AttendencePercentage="
				+ AttendencePercentage + ", email=" + email + ", courseCode=" + courseCode + ", marks=" + marks + "]";
	}



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



	public StudentDto() {
		super();
	}
	
	
	
	
	
}
