package com.emexo.spring.ioc.applicationcontext.classpath;

import org.springframework.stereotype.Component;

public class Address {
    private String street = "Neeladri Nager";
    private String city = "Bangalore";
    private String state = "Karnataka";

    public Address(){
        System.out.println("Default Constructor");
    }

    public void getAddress(){
        System.out.println(street);
        System.out.println(city);
        System.out.println(state);
    }
}
