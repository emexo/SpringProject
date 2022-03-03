package com.emexo.spring.autowiring;

public class Address {
    private String city;
    private String state;

    public void setCity(String city) {
        this.city = city;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void getAddressDetails(){
        System.out.println(city);
        System.out.println(state);
    }
}
