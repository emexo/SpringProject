package com.bankingmanagement.model;

import com.bankingmanagement.entity.Branch;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoanDTO {

    private String loanType;

    private int loanAmount;

    private BranchDTO branchDTO;

    private CustomerDTO customerDTO;
}
