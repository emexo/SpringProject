package com.emexo.spring.annotation.scope;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Scope("prototype")
@Component
public class Employee {
    private int empId = 10;
    private String empName = "Manoj";

    public Employee() {
        System.out.println("Default Constructor");
    }

    @PostConstruct
    public void getEmpDetails(){
        System.out.println(empId);
        System.out.println(empName);
    }

    @PreDestroy
    public void closeEmployee(){
        System.out.println("Pre destroy example");
    }
}
