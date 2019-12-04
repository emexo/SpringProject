package com.emexo.spring.mail.properties;

public class MailConfiguration {
    private String host;
    private int port;
    private String user;
    private String pass;

    public void setHost(String host) {
        this.host = host;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public void getEmailConfiguration(){
        System.out.println("Host: " +host);
        System.out.println("port: " +port);
        System.out.println("user: " +user);
        System.out.println("pass: " +pass);
    }
}
