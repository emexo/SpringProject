package com.emexo.spring.ioc.applicationcontext.classpath;

public class Address {
    private String street = "Neeladri Nager";
    private String city = "Bangalore";
    private String state = "Karnataka";

    public void getAddress(){
        System.out.println(street);
        System.out.println(city);
        System.out.println(state);
    }
}
