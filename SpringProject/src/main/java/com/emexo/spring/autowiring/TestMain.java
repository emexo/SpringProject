package com.emexo.spring.autowiring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestMain {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("autowiring.xml");
        Employee emp = context.getBean("employee", Employee.class);
        emp.getEmployeeDetails();
    }
}
