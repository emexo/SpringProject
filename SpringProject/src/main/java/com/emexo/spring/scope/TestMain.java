package com.emexo.spring.scope;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestMain {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("beanscope.xml");

		Employee emp1 = context.getBean("emp1", Employee.class);
		System.out.println(emp1.hashCode());

		Employee emp2 = context.getBean("emp1", Employee.class);
		System.out.println(emp2.hashCode());




	}

}
                   