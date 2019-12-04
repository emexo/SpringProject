package com.emexo.spring.di.setterconstructor;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestMain {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("setterconstructor.xml");

		Employee emp1 = context.getBean("emp2", Employee.class);
		emp1.getEmployeeDetails();
	}

}
