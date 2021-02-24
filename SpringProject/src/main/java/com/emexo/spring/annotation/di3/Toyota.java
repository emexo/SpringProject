package com.emexo.spring.annotation.di3;

import org.springframework.stereotype.Repository;


@Repository("toyota")
public class Toyota implements Vehicle {
    @Override
    public void engine() {
        System.out.println("Toyota Engine");
    }
}
