package com.ust.BranchManagement.Model;

//import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;


@Document
public class Branch {
	
	
	private int branchId;
	private String branchName;
	private int courseCode;
	
	@Override
	public String toString() {
		return "Branch [branchId=" + branchId + ", branchName=" + branchName + ", courseCode=" + courseCode + "]";
	}




	public int getBranchId() {
		return branchId;
	}




	public void setBranchId(int branchId) {
		this.branchId = branchId;
	}




	public String getBranchName() {
		return branchName;
	}




	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}




	public int getCourseCode() {
		return courseCode;
	}




	public void setCourseCode(int courseCode) {
		this.courseCode = courseCode;
	}




	public Branch() {
		super();
	}
	
	
}
