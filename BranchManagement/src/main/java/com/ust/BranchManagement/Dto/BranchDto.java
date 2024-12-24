package com.ust.BranchManagement.Dto;

public class BranchDto {

	private int BranchId;
	private String BranchName;
	private int courseCode;
	
	
	@Override
	public String toString() {
		return "BranchDto [BranchId=" + BranchId + ", BranchName=" + BranchName + ", courseCode=" + courseCode + "]";
	}

	public int getBranchId() {
		return BranchId;
	}


	public void setBranchId(int branchId) {
		BranchId = branchId;
	}

	public String getBranchName() {
		return BranchName;
	}


	public void setBranchName(String branchName) {
		BranchName = branchName;
	}


	public int getCourseCode() {
		return courseCode;
	}


	public void setCourseCode(int courseCode) {
		this.courseCode = courseCode;
	}


	public BranchDto() {
		super();
	}
	
	
}
