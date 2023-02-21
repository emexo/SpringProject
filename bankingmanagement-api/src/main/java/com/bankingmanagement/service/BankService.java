package com.bankingmanagement.service;

import com.bankingmanagement.exception.BankDetailsNotFound;
import com.bankingmanagement.model.BankDTO;

import java.util.List;

public interface BankService {
    List<BankDTO> findAll() throws BankDetailsNotFound;
    BankDTO findBankDetails(int code) throws BankDetailsNotFound;
}
