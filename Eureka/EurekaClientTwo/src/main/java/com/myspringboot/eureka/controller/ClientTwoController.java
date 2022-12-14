package com.myspringboot.eureka.controller;

import com.myspringboot.eureka.service.ClientTwoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClientTwoController {
    @Autowired
    ClientTwoService clientTwoService;

    @Autowired
    private DiscoveryClient discoveryClient;


    @GetMapping("/message")
    public String getMessage()
    {
           return clientTwoService.getMessage();
    }

    @GetMapping("/clients/{applicationName}")
    public @ResponseBody String getClientsByApplicationName(@PathVariable String applicationName) {
        return this.discoveryClient.getInstances(applicationName).get(0).getUri().toString();
    }

}
