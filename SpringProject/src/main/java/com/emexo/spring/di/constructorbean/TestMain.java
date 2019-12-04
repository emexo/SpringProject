package com.emexo.spring.di.constructorbean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestMain {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("construtorbean.xml");

        Student student = context.getBean("student", Student.class);
        student.getStudentDetails();
    }
}
