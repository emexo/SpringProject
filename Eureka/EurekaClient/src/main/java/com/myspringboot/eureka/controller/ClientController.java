package com.myspringboot.eureka.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClientController {
    @GetMapping("/message")
    public String getMessage()
    {
        return "Hello World!!!";
    }
}
