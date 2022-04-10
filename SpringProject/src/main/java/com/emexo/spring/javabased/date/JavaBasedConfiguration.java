package com.emexo.spring.javabased.date;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Description;
import org.springframework.context.annotation.Scope;

import java.util.Date;

@Configuration
public class JavaBasedConfiguration {

    @Description("Date bean")
    @Scope("prototype")
    @Bean(name = "date")
    public Date getDate(){
        Date date = new Date();
        return date;
    }
}
