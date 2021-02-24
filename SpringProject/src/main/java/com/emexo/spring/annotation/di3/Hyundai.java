package com.emexo.spring.annotation.di3;

import org.springframework.stereotype.Component;

@Component
public class Hyundai implements Vehicle {
    @Override
    public void engine() {
        System.out.println("###########Hyundai Engine##########");
    }
}
