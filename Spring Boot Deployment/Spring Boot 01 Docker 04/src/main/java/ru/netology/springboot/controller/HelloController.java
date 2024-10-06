package ru.netology.springboot.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.netology.springboot.SystemProfile;
import ru.netology.springboot.domain.Person;


@RestController

// Этот клас не относится к занаятию 01 StringBoot, это для занатия 02 REST
public class HelloController {

    @Value("myAppTest")
    private String from;


    @GetMapping("/hello")
    public String hello(Person guest) {

        return String.format("Hello from %s to name %s age %s!",
                from, guest.getName(), guest.getAge());
    }
}