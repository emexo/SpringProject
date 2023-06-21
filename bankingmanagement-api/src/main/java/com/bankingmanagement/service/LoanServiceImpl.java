package com.bankingmanagement.service;

import com.bankingmanagement.entity.Branch;
import com.bankingmanagement.entity.Customer;
import com.bankingmanagement.entity.Loan;
import com.bankingmanagement.exception.LoanNotFound;
import com.bankingmanagement.model.BranchDTO;
import com.bankingmanagement.model.CustomerDTO;
import com.bankingmanagement.model.LoanDTO;
import com.bankingmanagement.repository.LoanRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.Currency;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Loan service implementation
 */
@Slf4j
@Service
public class LoanServiceImpl implements LoanService {

    @Autowired
    LoanRepository loanRepository;

    /**
     * Get all the loans
     * @return
     * @throws LoanNotFound
     */
    public List<LoanDTO> findAllLoans() throws LoanNotFound {
        log.info("Inside the LoanServiceImpl.findAllLoans");

        List<Loan> loans = loanRepository.findAll();
        log.info("List of loans, loans:{}", loans);

        if(CollectionUtils.isEmpty(loans)){
            log.info("No loans found");
            throw new LoanNotFound("No loans found");
        }

        List<LoanDTO> loanDTOList = loans.stream().map(loan -> {
            LoanDTO loanDTO = new LoanDTO();
            loanDTO.setLoanType(loan.getLoanType());
            loanDTO.setLoanAmount(loan.getLoanAmount());

            Branch branch = loan.getBranch();
            if(branch != null) {
                BranchDTO branchDTO = new BranchDTO();
                branchDTO.setBranchName(branch.getBranchName());
                branchDTO.setBranchAddress(branch.getBranchAddress());
                loanDTO.setBranchDTO(branchDTO);
            }

            Customer customer = loan.getCustomer();
            if(customer != null) {
                CustomerDTO customerDTO = new CustomerDTO();
                customerDTO.setCustomerName(customer.getCustomerName());
                customerDTO.setCustomerAddress(customer.getCustomerAddress());
                customerDTO.setCustomerPhone(customer.getCustomerPhone());
                customerDTO.setCustomerID(customer.getCustomerID());
                loanDTO.setCustomerDTO(customerDTO);
            }

            return loanDTO;
        }).collect(Collectors.toList());

        log.info("End of LoanServiceImpl.findAllLoans");

        return loanDTOList;
    }

}
