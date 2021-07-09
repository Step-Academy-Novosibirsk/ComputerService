package ru.ipgolenischev.computerservice.controllers;

import daos.ServiceClientDao;
import models.ServiceClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    public HelloController() {

    }
    @GetMapping("/hello")
    public String hello(){
        return "Hello";
    }
}
