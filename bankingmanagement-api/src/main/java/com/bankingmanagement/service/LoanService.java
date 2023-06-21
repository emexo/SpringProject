package com.bankingmanagement.service;

import com.bankingmanagement.exception.LoanNotFound;
import com.bankingmanagement.model.LoanDTO;

import java.util.List;

public interface LoanService {
    List<LoanDTO> findAllLoans() throws LoanNotFound;
}
