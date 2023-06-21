package com.bankingmanagement.exception;

public class AccountNotFound extends Exception{
    public AccountNotFound(){
        super();
    }

    public AccountNotFound(String msg){
        super(msg);
    }

    public AccountNotFound(String msg, Throwable throwable){
        super(msg, throwable);
    }
}
