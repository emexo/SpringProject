package com.emexo.spring.javabased.date;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Date;

public class TestMainJavaBasedConfig {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("com.emexo.spring.javabased.date");
        Date date = context.getBean("date", Date.class);
        System.out.println(date);
    }
}
