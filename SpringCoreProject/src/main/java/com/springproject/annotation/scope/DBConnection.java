package com.emexo.annotation.scope;

import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Scope("prototype")
@Service
public class DBConnection {

    public DBConnection() {
        System.out.println(" ### Default Constructor###");
    }

    public void getConnection(){
        System.out.println("DB Connection");
    }
}
