package com.emexo.spring.annotation.di3;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Component
public class Toyota implements Vehicle {
    @Override
    public void engine() {
        System.out.println("Toyota Engine");
    }
}
