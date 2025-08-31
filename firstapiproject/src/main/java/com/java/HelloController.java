package com.java.helloworld.firstapiproject;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    
    @GetMapping("/hello")
    public String hello() {
        return "Hello World!";
    }
    
    @GetMapping("/")
    public String home() {
        return "Welcome to Hello World API! Try /hello endpoint.";
    }
}
