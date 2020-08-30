package com.springaop.example4.main;

import com.springaop.example4.dao.PassengerDao;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class PassengerManager {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.scan("com.springaop.example4");
        context.refresh();
        PassengerDao passengerDao = context.getBean("passengerDaoImpl", PassengerDao.class);

        System.out.println(passengerDao.getPassenger(1));
        context.close();
    }
}
