package com.emexo.annotation.componentscan;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestMain {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext("com.emexo.annotation.componentscan");
        ApacReport apacReport = context.getBean("apacReport", ApacReport.class);
        apacReport.getReport();
    }
}
