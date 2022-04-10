package com.emexo.spring.annotation.scope;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestMain {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("com.emexo.spring.annotation.scope");
        Employee emp = context.getBean("employee", Employee.class);
        context.close();
    }
}
