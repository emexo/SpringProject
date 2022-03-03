package com.emexo.spring.autowiring;

public class Employee {
    private int empId;
    private String empName;
    private Address address;

    public Employee() {
    }

    public Employee(Address address) {
        this.address = address;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public void getEmployeeDetails(){
        System.out.println(empId +""+empName);
        address.getAddressDetails();
    }

}
