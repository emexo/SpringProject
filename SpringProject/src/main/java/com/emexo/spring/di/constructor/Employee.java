package com.emexo.spring.di.constructor;

public class Employee {
	
	private int empId;
	private String empName;

	public Employee(int empId, String empName) {
		this.empId = empId;
		this.empName = empName;
	}

	public void getEmployeeDetails() {
		System.out.println("Emp Id : " + empId);
		System.out.println("Emp Name : " + empName);
	}
}
