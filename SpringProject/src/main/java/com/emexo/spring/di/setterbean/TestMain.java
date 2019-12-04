package com.emexo.spring.di.setterbean;

import com.emexo.spring.di.setterconstructor.Employee;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestMain {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("setterbean.xml");

        Student student = context.getBean("student", Student.class);
        student.getStudentDetails();
    }
}
