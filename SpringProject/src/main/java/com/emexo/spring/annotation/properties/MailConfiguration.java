package com.emexo.spring.annotation.properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.stereotype.Component;

@PropertySources({
        @PropertySource("mail.properties"),
        @PropertySource("db.properties")
})
//@PropertySource("mail.properties")
@Component
public class MailConfiguration {
    @Value("${smtp.host}")
    private String host;

    @Value("${smtp.port}")
    private int port;

    @Value("${smtp.user}")
    private String user;

    @Value("${smtp.pass}")
    private String pass;

    @Value("${DB_URL}")
    private String url;

    public void getEmailConfiguration(){
        System.out.println("Host: " +host);
        System.out.println("port: " +port);
        System.out.println("user: " +user);
        System.out.println("pass: " +pass);
        System.out.println("url: " +url);
    }
}
