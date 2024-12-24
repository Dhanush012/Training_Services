//package com.ust.BranchManagement.Service;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.web.reactive.function.client.WebClient;
//
//import com.ust.BranchManagement.Dto.BranchDto;
//import com.ust.BranchManagement.Dto.ResponseDto;
//import com.ust.BranchManagement.Dto.StudentDto;
//import com.ust.BranchManagement.Model.Branch;
//import com.ust.BranchManagement.Repository.BranchRepo;
//
//import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
//import reactor.core.publisher.Flux;
//import reactor.core.publisher.Mono;
//
//@Service
//public class BranchService {
//
//    @Autowired
//    private BranchRepo repo;
//
//    @Autowired
//    private WebClient webclient;
//
//    public Mono<Branch> addBranch(Branch branch) {
//        return repo.save(branch);
//    }
//
//    public Flux<Branch> getAllBranch() {
//        return repo.findAll();
//    }
//
//    @CircuitBreaker(name = "branchservice", fallbackMethod = "fallbackGetBranch")
//    public ResponseDto getCourseCode(int coursecode) {
//        ResponseDto responseDto = new ResponseDto();
//
//        // Fetch the branch
//        Branch branch = repo.findByCourseCode(coursecode)
//                .orElseThrow(() -> new RuntimeException("Course not found"));
//
//        // Map the branch to DTO
//        BranchDto branchDto = mapToBranchDto(branch);
//
//        // Fetch students reactively
//        Flux<StudentDto> studentList = webclient.get()
//                .uri("http://localhost:8084/student/" + branch.getCourseCode())
//                .retrieve()
//                .bodyToFlux(StudentDto.class);
//
//        // Set the DTO in the response
//        responseDto.setBranchdto(branchDto);
//        responseDto.setStudentdto(studentList);  // No blocking here, it remains reactive
//
//        return responseDto;
//    }
//
//    private BranchDto mapToBranchDto(Branch branch) {
//        BranchDto branchDto = new BranchDto();
//        branchDto.setBranchId(branch.getBranchId());
//        branchDto.setBranchName(branch.getBranchName());
//        branchDto.setCourseCode(branch.getCourseCode());
//        return branchDto;
//    }
//
//    public ResponseDto fallbackGetBranch(int coursecode, Throwable throwable) {
//        // Return a default response or handle the error
//        return new ResponseDto();
//    }
//}
package com.ust.BranchManagement.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.ust.BranchManagement.Dto.BranchDto;
import com.ust.BranchManagement.Dto.ResponseDto;
import com.ust.BranchManagement.Dto.StudentDto;
import com.ust.BranchManagement.Model.Branch;
import com.ust.BranchManagement.Repository.BranchRepo;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
//import io.vavr.collection.List;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class BranchService {

    @Autowired
    private BranchRepo repo;

    @Autowired
    private WebClient webclient;

    public Mono<Branch> addBranch(Branch branch) {
        return repo.save(branch);
    }

    public Flux<Branch> getAllBranch() {
        return repo.findAll();
    }

    @CircuitBreaker(name = "branchservice", fallbackMethod = "fallbackGetBranch")
    public Mono<ResponseDto> getCourseCode(int coursecode) {
        // Fetch the branch reactively
        Mono<Branch> branchMono = repo.findByCourseCode(coursecode)
                .switchIfEmpty(Mono.error(new RuntimeException("Course not found")));

        // Map the branch and fetch students reactively
        return branchMono.flatMap(branch -> {
            BranchDto branchDto = mapToBranchDto(branch);

            // Fetch students reactively
            Flux<StudentDto> studentFlux = webclient.get()
                    .uri("http://localhost:8084/student/" + branch.getCourseCode())
                    .retrieve()
                    .bodyToFlux(StudentDto.class);

            // Combine branchDto and studentFlux into ResponseDto
            return studentFlux.collectList().map(studentList -> {
                ResponseDto responseDto = new ResponseDto();
                responseDto.setBranchdto(branchDto);
                responseDto.setStudentdto(studentList); // Set the collected list
                return responseDto;
            });
        });
    }


    private BranchDto mapToBranchDto(Branch branch) {
        BranchDto branchDto = new BranchDto();
        branchDto.setBranchId(branch.getBranchId());
        branchDto.setBranchName(branch.getBranchName());
        branchDto.setCourseCode(branch.getCourseCode());
        return branchDto;
    }

    public ResponseDto fallbackGetBranch(int coursecode, Throwable throwable) {
        // Return a default response or handle the error
     // Empty student list
    	return new ResponseDto();
    }
}
