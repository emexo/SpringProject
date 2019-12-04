package com.emexo.spring.javabased;

import com.emexo.spring.annotation.di1.Organization;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestMain {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext  context = new AnnotationConfigApplicationContext();

        context.register(Student.class);
        context.refresh();

        Marks marks= context.getBean("marks", Marks.class);
        System.out.println(marks.getMark1());
        System.out.println(marks.getMark2());
        System.out.println(marks.getMark3());
        context.close();
    }
}
