package com.emexo.spring.ioc.applicationcontext.classpath;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestMain {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpathapplicationcontext.xml");

        Address address = context.getBean("address", Address.class);
        address.getAddress();

    }
}
