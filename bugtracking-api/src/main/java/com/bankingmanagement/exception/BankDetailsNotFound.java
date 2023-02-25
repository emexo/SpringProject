package com.bankingmanagement.exception;

public class BankDetailsNotFound extends Exception{
    public BankDetailsNotFound(){
        super();
    }

    public BankDetailsNotFound(String str){
        super(str);
    }
}
