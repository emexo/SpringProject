package com.emexo.annotation.bean;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AccountMain {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("com.emexo.annotation.bean");

        Account account = context.getBean("account", Account.class);
        account.getAccountDetails();
    }
}
