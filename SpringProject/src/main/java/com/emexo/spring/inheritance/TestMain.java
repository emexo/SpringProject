package com.emexo.spring.inheritance;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestMain {
    public static void main(String[] args) {
        AbstractApplicationContext context = new ClassPathXmlApplicationContext("templatebean.xml");
        Elephant elephant=(Elephant)context.getBean("elephant");
        System.out.println(elephant.getLocation());
        System.out.println(elephant.getName());
        System.out.println(elephant.getAge());
        context.registerShutdownHook();
    }
}
