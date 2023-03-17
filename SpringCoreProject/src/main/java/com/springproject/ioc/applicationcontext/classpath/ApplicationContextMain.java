package com.springproject.ioc.applicationcontext.classpath;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class ApplicationContextMain {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpathxmlapplicationcontext.xml");

        Employee employee = context.getBean("employee", Employee.class);
        //employee.getEmployeeDetails();
    }
}
