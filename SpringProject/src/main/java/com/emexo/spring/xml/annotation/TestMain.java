package com.emexo.spring.xml.annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestMain {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("xml-annotation-application-context.xml");

		Customer cust = (Customer) context.getBean("customer");
		System.out.println(cust);
		context.close();
	}
}