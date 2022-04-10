package com.emexo.spring.annotation.componentscan;

import javafx.scene.AmbientLight;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestMain {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(ComponentScanConfig.class);
        context.refresh();
        Employee employee = context.getBean("employee", Employee.class);
        employee.getEmployeedetails();
    }
}
