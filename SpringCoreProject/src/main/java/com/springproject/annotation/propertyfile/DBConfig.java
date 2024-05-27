package com.emexo.annotation.propertyfile;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.stereotype.Component;

 // load the property file
@PropertySource("application.properties")
@Component
public class DBConfig {

    @Value("${db.driver}") // read the data from property file
    private String driverClassName;

    @Value("${db.url}")
    private String url;

    @Value("${db.username}")
    private String username;

     @Value("${db.password}")
    private String password;

     public void getDBConnection(){
         System.out.println(url + " : "+ username + " : "+ password + " : "+ driverClassName);
     }

}
