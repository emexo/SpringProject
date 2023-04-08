package com.emexo.spring.cloud.security.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class AppController {
    @GetMapping("/")
    public String message(Principal principal) {
        return "Hi "+principal.getName()+" welcome to SpringCloudOauth2ExampleApplication";
    }

    @GetMapping("/redirect")
    public String message1(Principal principal) {
        return "Hi "+principal.getName()+" welcome to SpringCloudOauth2ExampleApplication";
    }
}
