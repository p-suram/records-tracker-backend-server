package com.example.springbootbackendserver.controller;

import com.example.springbootbackendserver.Greeting;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    @GetMapping("/greeting")
    public Greeting greeting() throws InterruptedException {
        Thread.sleep(6000);
        return new Greeting("Welcome");
    }


    @GetMapping("/wishes")
    public Greeting wishes() throws InterruptedException {
        Thread.sleep(8000);
        return new Greeting("Happy Birthday");
    }

}
