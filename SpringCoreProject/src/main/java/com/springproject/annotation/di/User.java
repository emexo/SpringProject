package com.emexo.annotation.di;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.inject.Named;

/**
 * @Resource - JSR 250
 * Match by Name
 * Match by Type
 * Match by Qualifier
 *
 * @Inject - JSR - 330
 * Match by Type
 * Match by Qualifier
 * Match by Name
 *
 * @Autowired
 * Match by Type
 * Match by Qualifier
 * Match by Name
 */
@Component
public class User {

   @Autowired
   Toyota toyota;


    public void print() {
        toyota.engine();
    }

}


