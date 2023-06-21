package com.bankingmanagement.exception;

import com.bankingmanagement.repository.LoanRepository;

public class LoanNotFound extends Exception{
    public LoanNotFound(){
        super();
    }

    public LoanNotFound(String msg){
        super(msg);
    }

    public LoanNotFound(Throwable t, String msg){
        super(msg, t);
    }
}
