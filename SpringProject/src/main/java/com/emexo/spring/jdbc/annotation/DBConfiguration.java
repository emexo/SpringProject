package com.emexo.spring.jdbc.annotation;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Component;

@PropertySource("classpath:db.properties")
@Configuration
public class DBConfiguration {

    @Value("${DB_DRIVER}")
    private String driverClass;

    @Value("${DB_URL}")
    private String url;

    @Value("${DB_USERNAME}")
    private String username;


    @Value("${DB_PASSWORD}")
    private String password;


    @Bean(name = "jdbcTemplate")
    public JdbcTemplate getConnection(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(driverClass);
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);

        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(dataSource);

        return jdbcTemplate;
    }
}
