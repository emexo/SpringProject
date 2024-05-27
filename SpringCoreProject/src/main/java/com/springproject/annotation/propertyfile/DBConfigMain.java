package com.emexo.annotation.propertyfile;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class DBConfigMain {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext("com.emexo.annotation.propertyfile");

        DBConfig dbConfig = context.getBean("DBConfig", DBConfig.class);
        dbConfig.getDBConnection();
    }
}
