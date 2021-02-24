package com.emexo.spring.annotation.di3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * @Resource - JSR 250
 * Match by Name
 * Match by Type
 * Match by Qualifier
 * @Inject - JSR - 330
 * Match by Type
 * Match by Qualifier
 * Match by Name - @Named
 * @Autowired
 * Match by Type
 * Match by Qualifier
 * Match by Name
 */
@Component
public class User {

    @Qualifier("honda")
   @Autowired
    Vehicle honda1;

    public User(Honda honda) {
        this.honda1 = honda;
    }

    public void print() {
        honda1.engine();
    }

}
