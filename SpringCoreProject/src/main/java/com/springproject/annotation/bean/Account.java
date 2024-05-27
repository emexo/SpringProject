package com.emexo.annotation.bean;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

@Component
public class Account {

    private static final Logger log = LogManager.getLogger(Account.class);

    private int accountNo;
    private String accountName;

    public Account(){
        this.accountNo = 1;
        this.accountName = "Prabhu";
    }

    public void getAccountDetails(){
        log.info("Account no: {}, and Account Name:{} ", accountNo, accountName);
    }

}
