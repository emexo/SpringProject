package com.bankingmanagement.controller;

import com.bankingmanagement.exception.LoanNotFound;
import com.bankingmanagement.model.LoanDTO;
import com.bankingmanagement.service.LoanService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/v1/loans")
public class LoanController {

    @Autowired
    LoanService loanService;

    @GetMapping
    public ResponseEntity<List<LoanDTO>> getAllLoans() {
        log.info("Inside the LoanController.getAllLoans");

        List<LoanDTO> loanDTOList;
        try {
            loanDTOList = loanService.findAllLoans();
            log.info("List of loans, loanDTOList:{}", loanDTOList);
        }catch (LoanNotFound ex){
            log.error("Loan details not found", ex);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }catch (Exception ex){
            log.error("Exception while getting the loans", ex);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        log.info("End of LoanController.getAllLoans");
        return new ResponseEntity<>(loanDTOList, HttpStatus.OK);
    }

}
