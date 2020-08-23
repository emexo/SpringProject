package com.springaop.example1.main;

import com.springaop.example1.dao.PassengerDao;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PassengerManager {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("example1/aop.xml");

        PassengerDao passengerDao = context.getBean("passengerDao", PassengerDao.class);

        System.out.println(passengerDao.getPassenger(1));
        context.close();
    }
}
