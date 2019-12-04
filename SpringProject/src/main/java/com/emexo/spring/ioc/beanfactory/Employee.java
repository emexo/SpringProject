package com.emexo.spring.ioc.beanfactory;

public class Employee {
    private int empId = 10;
    private String empName = "Satish";

    public void getEmployeeDetails(){
        System.out.println("Employee Id : " + empId);
        System.out.println("Employee Name : "+ empName);
    }
}
