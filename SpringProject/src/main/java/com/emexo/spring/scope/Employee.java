package com.emexo.spring.scope;

public class Employee {
	
	private int empId;
	private String empName;
	
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}


	public Employee() {
		System.out.println("Employee Constructor");
	}

	public void getEmployeeDetails() {
		System.out.println("Emp Id : " + empId);
		System.out.println("Emp Name : " + empName);
	}

}
