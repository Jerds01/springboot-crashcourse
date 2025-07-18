package com.example.demo.myfirstapi.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @GetMapping("/greeting")
    public String greetWithParam(@RequestParam(value = "name",required = false, defaultValue = "World") String name){
        return "Hello, "+name+"!";
    }

    @GetMapping("/calculate/sum")
    public String sumNumbers(@RequestParam("num1") int num1,@RequestParam("num2") int num2){
        int sum = num1+num2;
        return "num1: " + num1 + "+ num2: " + num2 + " = sum: " + sum;
    }

    @GetMapping("/info")
    public Map<String, String> getAppInfo() {
        Map<String, String> info = new HashMap<>();
        info.put("appName", "MyFirstSpringBootAPI");
        info.put("version", "1.0.0");
        info.put("status", "Running");
        return info;
    }

    @GetMapping("/features")
    public List<String> getFeatures() {
        return Arrays.asList("REST API", "Spring Boot", "Easy Setup", "Fast Development");
    }

}
