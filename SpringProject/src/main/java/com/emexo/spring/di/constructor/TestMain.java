package com.emexo.spring.di.constructor;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestMain {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("constructor.xml");

		Employee emp1 = context.getBean("emp1", Employee.class);
		emp1.getEmployeeDetails();
	}

}
