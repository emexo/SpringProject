package com.emexo.spring.annotation.di;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Primary
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
