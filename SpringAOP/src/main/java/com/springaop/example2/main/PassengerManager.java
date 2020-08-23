package com.springaop.example2.main;

import com.springaop.example2.dao.PassengerDao;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PassengerManager {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("example2/aop.xml");

        PassengerDao passengerDao = context.getBean("passengerDao", PassengerDao.class);

        System.out.println(passengerDao.getPassenger(1));
        passengerDao.getPassenger1();
        context.close();
    }
}
