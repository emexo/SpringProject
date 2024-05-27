package com.emexo.annotation.commonlib;

import org.springframework.stereotype.Component;

@Component
public class Transaction {
    public void getTransactionDetails(){
        System.out.println("Transaction");
    }
}
