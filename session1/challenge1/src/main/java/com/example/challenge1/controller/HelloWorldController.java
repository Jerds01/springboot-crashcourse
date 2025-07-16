package com.example.demo.myfirstapi.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController{

    @Value("${app.greeting.message}") // Inject value from application.properties
    String customGreeting;

    @GetMapping("/hello")
    public String sayHello(){

//        @Value("${app.greeting.message}")
//        private String custom_greeting;


        return customGreeting;
    }



    @GetMapping("/greet/{name}")
    public String sayHelloToName(@PathVariable String name){
        return "Hello, Springboot "+ name;

    }


}
