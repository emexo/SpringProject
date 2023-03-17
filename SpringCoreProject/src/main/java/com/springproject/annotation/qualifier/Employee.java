package com.springproject.annotation.qualifier;

import org.springframework.stereotype.Component;

@Component
public class Employee {
    private int empId;

    private String empName;

    public Employee(){
        System.out.println("Default constructor");
        this.empId = 1;
        this.empName = "Raju";
    }

    public void getEmployeeDetails(){
        System.out.println(empId);
        System.out.println(empName);
    }
}
