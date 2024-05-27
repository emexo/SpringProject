package com.emexo.annotation.postconstructpredestroy;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AccountMain {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("com.emexo.annotation.postconstructpredestroy");

        AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);


        // invoke save op
        context.close();

    }
}
