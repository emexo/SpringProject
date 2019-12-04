package com.tim.dao;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Component;

@PropertySource("classpath:application.properties")
@Configuration
public class DBConfiguration {
        private static final Logger LOGGER =
LogManager.getLogger(DBConfiguration.class.getName());

        @Value("${jdbc.driver}")
        private String driverClassName;
        @Value("${jdbc.url}")
        private String url;
        @Value("${jdbc.user}")
        private String userName;
        @Value("${jdbc.password}")
        private String password;

        @Bean(name = "jdbcTemplate")
        public JdbcTemplate getDataSource() {
                LOGGER.info("username: "+userName ," password:  + password");
                JdbcTemplate jt = null;
                try {
                        DriverManagerDataSource dataSource = new DriverManagerDataSource();
                        dataSource.setDriverClassName(driverClassName);
                        dataSource.setUrl(url);
                        dataSource.setUsername(userName);
                        dataSource.setPassword(password);

                        jt = new JdbcTemplate(dataSource);
                } catch (Exception e) {
                        LOGGER.error("invalid db configuration", e);
                }

                return jt;
        }

        // to resolve ${} in @ value
        @Bean
        public static PropertySourcesPlaceholderConfigurer propertyConfigInDev() {
                return new PropertySourcesPlaceholderConfigurer();
        }

}