package com.emexo.spring.ioc.applicationcontext.classpath;

import com.emexo.spring.ioc.applicationcontext.filesystem.Organization;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class TestMain {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpathapplicationcontext.xml");

        Address address = context.getBean("address", Address.class);
        address.getAddress();

    }
}
