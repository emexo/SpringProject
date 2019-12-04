package com.emexo.spring.ioc.beanfactory;

public class Student {
	private int studentId = 1;
	private String studentName="Regu";
	
	public void getStudentDetails() {
		System.out.println("Student Id: " + studentId );
		System.out.println("Student Name: " + studentName );
	}

}
