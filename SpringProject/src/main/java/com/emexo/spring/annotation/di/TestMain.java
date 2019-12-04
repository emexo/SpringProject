package com.emexo.spring.annotation.di;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestMain {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext  context = new AnnotationConfigApplicationContext();

        context.scan("com.emexo.spring.annotation.di");
        context.refresh();

        Employee emp = context.getBean("employee", Employee.class);
        emp.getEmployeedetails();

    }
}
