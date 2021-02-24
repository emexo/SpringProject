package com.emexo.spring.annotation.di3;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestMain {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext  context = new AnnotationConfigApplicationContext();

        context.scan("com.emexo.spring.annotation.di3");
        context.refresh();

        User user = context.getBean("user", User.class);
        user.print();

        context.close();
    }
}
