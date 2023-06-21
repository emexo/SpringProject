package com.bankingmanagement.controller;

import com.bankingmanagement.exception.AccountNotFound;
import com.bankingmanagement.model.AccountDTO;
import com.bankingmanagement.model.AccountRequest;
import com.bankingmanagement.service.AccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/v1/accounts")
public class AccountController {

    @Autowired
    AccountService accountService;

    @GetMapping
    public ResponseEntity<List<AccountDTO>> getAllAccounts() {
       log.info("Inside the AccountController.getAllAccounts");
       List<AccountDTO> accountDTOList = null;
       try {
           accountDTOList = accountService.findAllAccounts();
           log.info("Account List:{}", accountDTOList);
        } catch (AccountNotFound ex1){
           log.error("Account Details Not found", ex1);
           return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception ex){
           log.error("Exception while getting the accounts", ex);
           return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
       }

       log.info("End of AccountController.getAllAccounts");
       return new ResponseEntity<>(accountDTOList, HttpStatus.OK);
   }

    // http://localhost:9090/api/v1/accounts/1/name - @PathVariable
    //http://localhost:9090/api/v1/accounts?id=1&name=ddd - RequestParam

    @GetMapping("/{accountNumber}")
    public ResponseEntity<AccountDTO> getAccountByAccountNumber(@PathVariable("accountNumber") int accountNumber){
        log.info("Inside the AccountController.getAccountByAccountNumber, accountNumber:{}", accountNumber);
        if(accountNumber <=0){
            log.info("Invalid Account Number, accountNumber:{}", accountNumber);
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        AccountDTO accountDTO = null;
        try{
            accountDTO = accountService.findAccountsByAccountNumber(accountNumber);
            log.info("Get account by accountNumber,accountDTO:{} ", accountDTO);

            if(accountDTO == null){
                log.info("No data found for the account number, accountNumber:{}", accountNumber);
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception ex){
            log.error("Exception while getting the account by account number", ex);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(accountDTO, HttpStatus.OK);
    }


    @PostMapping
    public ResponseEntity<AccountDTO> saveAccount(@RequestBody AccountRequest accountRequest){
        log.info("Inside the AccountController.saveAccount,accountRequest:{} ", accountRequest);

        if(accountRequest == null || accountRequest.getAccountBalance() <=0 || accountRequest.getAccountType() == null){
            log.info("Invalid account request");
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        AccountDTO accountDTO = null;
        try{
            accountDTO = accountService.saveAccount(accountRequest);
            log.info("Account details, accountDTO:{}", accountDTO);
        } catch (Exception ex){
            log.error("Exception while saving the account details", ex);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        log.info("End of AccountController.saveAccount");
        return new ResponseEntity<>(accountDTO, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<AccountDTO> updateAccount(@RequestBody AccountRequest accountRequest){
        log.info("Inside the AccountController.saveAccount,accountRequest:{} ", accountRequest);

        if(accountRequest == null || accountRequest.getAccountBalance() <=0 || accountRequest.getAccountType() == null){
            log.info("Invalid account request");
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        AccountDTO accountDTO = null;
        try{
            accountDTO = accountService.saveAccount(accountRequest);
            log.info("Account details, accountDTO:{}", accountDTO);
        } catch (Exception ex){
            log.error("Exception while saving the account details", ex);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        log.info("End of AccountController.saveAccount");
        return new ResponseEntity<>(accountDTO, HttpStatus.OK);
    }
}
