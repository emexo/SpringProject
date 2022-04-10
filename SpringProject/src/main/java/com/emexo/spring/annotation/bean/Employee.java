package com.emexo.spring.annotation.bean;

import org.springframework.stereotype.Service;

@Service("employee")
public class Employee {
    private int empId= 10;
    private String empName = "Sanjay";

    public void getEmployeeDetails(){
        System.out.println(empId);
        System.out.println(empName);
    }
}
