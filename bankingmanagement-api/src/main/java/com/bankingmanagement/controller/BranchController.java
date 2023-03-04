package com.bankingmanagement.controller;

import com.bankingmanagement.model.BranchDTO;
import com.bankingmanagement.service.BranchService;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.AfterThrowing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/v1/branches")
public class BranchController {

    @Autowired
    BranchService branchService;

    //http://localhost:9090/api/v1/branches/1
    @GetMapping("/{branchId}")
    public ResponseEntity<BranchDTO> getBranchById(@PathVariable("branchId") int branchId){
        log.info("Input to BranchController.getBranchById, branchId:{}", branchId);

        if(branchId <=0){
            log.info("Invalid branch Id");
            new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        BranchDTO branchDTO = null;
        try {
            branchDTO = branchService.getBranchById(branchId);
            log.info("Get Branch by id response, branchDTO:{}", branchDTO);
        } catch (Exception ex){
            log.error("Exception while getting branch details by id", ex);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<BranchDTO>(branchDTO, HttpStatus.OK);
    }

    //http://localhost:9090/api/v1/branches/byName?name=SBI
    @GetMapping("/byName")
    public ResponseEntity<BranchDTO> getBranchByName(@RequestParam("byName") String branchName){
        log.info("Input to BranchController.getBranchByName, branchName:{}", branchName);

        if(branchName == null){
            log.info("Invalid branch Name");
            new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        BranchDTO branchDTO = null;
        try {
            branchDTO = branchService.getBranchByName(branchName);
            log.info("Get Branch by Name response, branchDTO:{}", branchDTO);
        } catch (Exception ex){
            log.error("Exception while getting branch details by name", ex);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<BranchDTO>(branchDTO, HttpStatus.OK);
    }

}
