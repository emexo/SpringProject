package com.emexo.spring.ioc.beanfactory;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

public class TestMain {

    public static void main(String[] args) {
        XmlBeanFactory factory = new XmlBeanFactory(new ClassPathResource("beanfactory.xml"));

        Student student = (Student) factory.getBean("stud");

        student.getStudentDetails();

        Employee emp = factory.getBean("emp", Employee.class);

        emp.getEmployeeDetails();

    }

}
