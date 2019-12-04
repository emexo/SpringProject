package com.emexo.spring.annotation.di1;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Scope("singleton")
@Component("address")
public class Address {

    @Value("Bangalore")
    private String city;

    @Value("India")
    private String country;

    public void getAddressSetails(){
        System.out.println("City :" + city);
        System.out.println("Country :" + country);
    }

}
