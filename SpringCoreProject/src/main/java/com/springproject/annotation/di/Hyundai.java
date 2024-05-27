package com.emexo.annotation.di;

import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;


@Component
public class Hyundai implements Vehicle {
    @Override
    public void engine() {
        System.out.println("####Hyundai Engine####");
    }
}
