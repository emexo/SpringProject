package com.emexo.spring.di.setterconstructor;

public class Employee {
	private int empId;
	private String empName;
	private int age;
	private String email;
	
	public Employee(int empId, String empName) {
		this.empId = empId;
		this.empName = empName;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public void getEmployeeDetails() {
		System.out.println("Emp Id : " + empId);
		System.out.println("Emp Name : " + empName);
		System.out.println("Age : " + age);
		System.out.println("Email : " + email);
	}

}
