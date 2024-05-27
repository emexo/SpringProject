package com.emexo.annotation.di;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;




@Component
public class Honda implements Vehicle {
    @Override
    public void engine() {
        System.out.println("####Honda Engine####");
    }
}

