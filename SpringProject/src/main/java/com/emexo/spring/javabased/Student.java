package com.emexo.spring.javabased;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Description;
import org.springframework.context.annotation.Scope;

@Configuration("student")
public class Student {

    @Description("marks bean")
    @Scope("singleton")
    @Bean(name="marks",initMethod = "init", destroyMethod = "destroy")
    public Marks marks(){
        Marks marks = new Marks();
        marks.setMark1(90);
        marks.setMark2(80);
        marks.setMark3(70);
        return marks;
    }
}
