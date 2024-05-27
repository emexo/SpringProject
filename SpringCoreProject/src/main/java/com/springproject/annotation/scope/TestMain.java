package com.emexo.annotation.scope;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestMain {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext("com.emexo.annotation.scope");

       DBConnection connection = context.getBean("DBConnection", DBConnection.class);
        System.out.println(connection.hashCode());

        DBConnection connection1 = context.getBean("DBConnection", DBConnection.class);
        System.out.println(connection1.hashCode());
    }
}
