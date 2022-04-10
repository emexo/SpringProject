package com.emexo.spring.annotation.di3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.inject.Named;

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


    @Autowired
    Vehicle honda;

    public User() {
    }

    public void print() {
        honda.engine();
    }

}
