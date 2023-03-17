package com.springproject.ioc.beanfactory;

public class Employee {
    private int employeeId;
    private String employeeName;

    public Employee() {
        System.out.println("Default Constructor");
        this.employeeId = 1;
        this.employeeName = "Varad";
    }

    public void getEmployeeDetails(){
        System.out.println("Employee Id and Name :" + employeeId + " : " + employeeName);
    }
}
