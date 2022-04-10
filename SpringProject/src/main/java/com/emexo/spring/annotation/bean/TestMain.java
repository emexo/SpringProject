package com.emexo.spring.annotation.bean;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestMain {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext  context = new AnnotationConfigApplicationContext();

        context.scan("com.emexo.spring.annotation.bean");
        context.refresh();

        Organization org = context.getBean("organization", Organization.class);
        org.getOrgDetails();

        Employee employee = context.getBean("employee", Employee.class);
        employee.getEmployeeDetails();

    }
}
