package com.myspringboot.eureka;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestConfiguration {

    @LoadBalanced
    @Bean(name = "restTemplate")
    public RestTemplate getRestTemplate(){
        RestTemplate template = new RestTemplate();
        return template;
    }
}