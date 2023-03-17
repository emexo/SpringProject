package com.springproject.annotation.bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

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
