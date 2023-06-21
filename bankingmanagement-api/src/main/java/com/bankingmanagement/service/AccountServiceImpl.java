package com.bankingmanagement.service;

import com.bankingmanagement.entity.Account;
import com.bankingmanagement.entity.Branch;
import com.bankingmanagement.exception.AccountNotFound;
import com.bankingmanagement.model.AccountDTO;
import com.bankingmanagement.model.AccountRequest;
import com.bankingmanagement.model.BranchDTO;
import com.bankingmanagement.model.CustomerDTO;
import com.bankingmanagement.repository.AccountRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class AccountServiceImpl implements AccountService{

    @Autowired
    AccountRepository accountRepository;

    @Override
    public List<AccountDTO> findAllAccounts() throws AccountNotFound {
        log.info("Inside the AccountServiceImpl.findAllAccounts");
        List<Account> accountList = accountRepository.findAll();
        log.info("Account List: {}", accountList);

        if(CollectionUtils.isEmpty(accountList)){
            log.info("Account details not found");
            throw new AccountNotFound("Account details not found");
        }

        List<AccountDTO> accountDTOList = accountList.stream().map(account -> {
            AccountDTO accountDTO = new AccountDTO();
            accountDTO.setAccountNumber(account.getAccountNumber());
            accountDTO.setAccountType(account.getAccountType());
            accountDTO.setAccountBalance(account.getAccountBalance());

            BranchDTO branchDTO = new BranchDTO();
            branchDTO.setBranchName(account.getBranch().getBranchName());
            branchDTO.setBranchAddress(account.getBranch().getBranchAddress());
            accountDTO.setBranchDTO(branchDTO);

            CustomerDTO customerDTO = new CustomerDTO();
            customerDTO.setCustomerName(account.getCustomer().getCustomerName());
            customerDTO.setCustomerAddress(account.getCustomer().getCustomerAddress());
            accountDTO.setCustomerDTO(customerDTO);

            return accountDTO;
        }).collect(Collectors.toList());

        log.info("End of AccountServiceImpl.findAllAccounts");
        return accountDTOList;
    }

    @Override
    public AccountDTO findAccountsByAccountNumber(int accountNumber) throws AccountNotFound {
       log.info("Inside the AccountServiceImpl.findAccountsByAccountNumber, accountNumber:{}", accountNumber);

       Optional<Account> OptionalAccount = accountRepository.findById(accountNumber);
       log.info("Get account by accountNumber:{}, response, {}", accountNumber, OptionalAccount.get());
       if(!OptionalAccount.isPresent()){
           log.info("No data found for the account number:{}", accountNumber);
           throw new AccountNotFound("Account not found");
       }

       AccountDTO accountDTO = new AccountDTO();
       Account account = OptionalAccount.get();
        accountDTO.setAccountNumber(account.getAccountNumber());
        accountDTO.setAccountType(account.getAccountType());
        accountDTO.setAccountBalance(account.getAccountBalance());

        BranchDTO branchDTO = new BranchDTO();
        branchDTO.setBranchName(account.getBranch().getBranchName());
        branchDTO.setBranchAddress(account.getBranch().getBranchAddress());
        accountDTO.setBranchDTO(branchDTO);

        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setCustomerName(account.getCustomer().getCustomerName());
        customerDTO.setCustomerAddress(account.getCustomer().getCustomerAddress());
        accountDTO.setCustomerDTO(customerDTO);

        return accountDTO;
    }

    @Override
    public AccountDTO saveAccount(AccountRequest accountRequest) throws AccountNotFound {
        log.info("Input to AccountServiceImpl.saveAccount, accountRequest:{}", accountRequest);

        Account accountEntity = new Account();
        accountEntity.setAccountBalance(accountRequest.getAccountBalance());
        accountEntity.setAccountType(accountRequest.getAccountType());
        Account account = accountRepository.save(accountEntity);
        log.info("Account Details, account:{}", account);

        if(account == null){
            log.error("Account details not persisted");
            throw new AccountNotFound("Account details not persisted");
        }

        AccountDTO accountDTO = new AccountDTO();
        accountDTO.setAccountNumber(account.getAccountNumber());
        accountDTO.setAccountType(account.getAccountType());
        accountDTO.setAccountBalance(account.getAccountBalance());

        BranchDTO branchDTO = new BranchDTO();
        branchDTO.setBranchName(account.getBranch().getBranchName());
        branchDTO.setBranchAddress(account.getBranch().getBranchAddress());
        accountDTO.setBranchDTO(branchDTO);

        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setCustomerName(account.getCustomer().getCustomerName());
        customerDTO.setCustomerAddress(account.getCustomer().getCustomerAddress());
        accountDTO.setCustomerDTO(customerDTO);

        return accountDTO;

    }


}
