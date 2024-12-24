package com.ust.BranchManagement.Dto;

import java.util.List;

public class ResponseDto {

    private BranchDto branchdto;
    private List<StudentDto> studentdto;

    

    public ResponseDto(BranchDto branchdto, List<StudentDto> studentdto) {
		super();
		this.branchdto = branchdto;
		this.studentdto = studentdto;
	}

	public BranchDto getBranchdto() {
		return branchdto;
	}

	public void setBranchdto(BranchDto branchdto) {
		this.branchdto = branchdto;
	}

	public List<StudentDto> getStudentdto() {
		return studentdto;
	}

	public void setStudentdto(List<StudentDto> studentdto) {
		this.studentdto = studentdto;
	}

	public ResponseDto() {
        super();
    }

    @Override
    public String toString() {
        return "ResponseDto [branchdto=" + branchdto + ", studentdto=" + studentdto + "]";
    }
}
