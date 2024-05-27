package com.emexo.annotation.propertyfile;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/*@PropertySources({
        @PropertySource("classpath:mail.properties"),
        @PropertySource("classpath:db.properties")
})*/
@PropertySource("classpath:mail.properties")  // load the property file
@Component
public class MailConfiguration {
    private static final Logger log = LogManager.getLogger(MailConfiguration.class);
    @Value("${smtp.host}") // read the data from property file
    private String host;

    @Value("${smtp.port}")
    private int port;

    @Value("${smtp.user}")
    private String username;

    @Value("${smtp.pass}")
    private String password;



    public void getMailConfiguration(){
        log.info("Mail JavaBasedConfiguration, host:{}, port:{}, username:{} and password:{}", host, port,
                username, password);
    }
}
