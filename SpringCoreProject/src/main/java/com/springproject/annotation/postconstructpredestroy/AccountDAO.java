package com.emexo.annotation.postconstructpredestroy;

import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Repository
public class AccountDAO {

    @PostConstruct
    public void getConnection(){
        System.out.println("Connecting to DB");
    }

    // save

    // update

    // delect

    @PreDestroy
    public void closeConnection(){
        System.out.println("Closing the DB Connection");
    }
}
