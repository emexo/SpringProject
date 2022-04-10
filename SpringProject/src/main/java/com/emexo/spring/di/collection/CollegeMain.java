package com.emexo.spring.di.collection;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CollegeMain {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("collection.xml") ;
        College college = context.getBean("college", College.class);
        college.getCollegeDetails();
    }
}
