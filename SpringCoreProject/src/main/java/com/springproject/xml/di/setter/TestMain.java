package com.springproject.xml.di.setter;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestMain {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("setter.xml");
        Student student= context.getBean("student", Student.class);
        student.getStudentDetails();
    }
}
