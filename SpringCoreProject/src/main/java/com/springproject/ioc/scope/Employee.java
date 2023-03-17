package com.springproject.ioc.scope;

public class Employee {
    private int employeeId;
    private String employeeName;

    public Employee() {
        System.out.println("Default Constructor");
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public void getEmployeeDetails(){
        System.out.println("Employee Id and Name :" + employeeId + " : " + employeeName);
    }
}
