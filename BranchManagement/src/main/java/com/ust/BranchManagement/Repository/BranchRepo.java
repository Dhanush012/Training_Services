package com.ust.BranchManagement.Repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

//import com.ust.BranchManagement.Dto.ResponseDto;
import com.ust.BranchManagement.Model.Branch;

import reactor.core.publisher.Mono;

@Repository
public interface BranchRepo extends ReactiveMongoRepository<Branch, Integer>{

//	Optional<Branch> findByCourseCode(int coursecode);
	Mono<Branch> findByCourseCode(int courseCode);

	
}
