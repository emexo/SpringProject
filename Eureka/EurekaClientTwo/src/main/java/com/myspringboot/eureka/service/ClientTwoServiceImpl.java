package com.myspringboot.eureka.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
public class ClientTwoServiceImpl implements ClientTwoService{

    @Autowired
    RestTemplate restTemplate;

    @Override
    public String getMessage() {
        final String url = "http://eureka-client-service/message";
        String response = null;
        try {
            response = restTemplate.getForObject(url, String.class);
            System.out.println("Inside Service"+response);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Inside Service"+response);
        return response;
    }
}
