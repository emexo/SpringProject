package com.bankingmanagement.service;

import com.bankingmanagement.entity.Account;
import com.bankingmanagement.exception.AccountNotFound;
import com.bankingmanagement.model.AccountDTO;
import com.bankingmanagement.model.AccountRequest;

import java.util.List;

public interface AccountService {
    List<AccountDTO> findAllAccounts() throws AccountNotFound;

    AccountDTO findAccountsByAccountNumber(int accountNumber) throws AccountNotFound;

    AccountDTO saveAccount(AccountRequest accountRequest) throws AccountNotFound;
}
