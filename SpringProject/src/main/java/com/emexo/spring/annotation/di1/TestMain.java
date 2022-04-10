package com.emexo.spring.annotation.di1;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestMain {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext  context = new AnnotationConfigApplicationContext();

        context.scan("com.emexo.spring.annotation.di1");
        context.refresh();

        Organization org = context.getBean("org", Organization.class);
        org.getOrgDetails();

        context.close();
    }
}
