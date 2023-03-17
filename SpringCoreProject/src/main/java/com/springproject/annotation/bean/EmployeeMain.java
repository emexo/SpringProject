package com.springproject.annotation.bean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class EmployeeMain {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext("com.springproject.annotation.bean");

       Employee employee = context.getBean("employee", Employee.class);
       employee.getEmployeeDetails();

       Student student = (Student) context.getBean("student");
       student.getStudentDetails();
    }
}
