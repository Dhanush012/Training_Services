package com.ust.BranchManagement.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ust.BranchManagement.Dto.ResponseDto;
import com.ust.BranchManagement.Model.Branch;
import com.ust.BranchManagement.Service.BranchService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/branch")
public class BranchController {
	
	@Autowired
	private BranchService service;
	
	@PostMapping("/addbranch")
	public Mono<Branch> addBranch(@RequestBody Branch branch) {
		return service.addBranch(branch);
	}
	
	@GetMapping("/allbranch")
	public Flux<Branch> getAllBranch(){
		return service.getAllBranch();
	}
	
	@GetMapping("{CourseCode}")
	public Mono<ResponseDto> getStudent(@PathVariable("CourseCode") int coursecode) {
	    return service.getCourseCode(coursecode);
	}

	

}
