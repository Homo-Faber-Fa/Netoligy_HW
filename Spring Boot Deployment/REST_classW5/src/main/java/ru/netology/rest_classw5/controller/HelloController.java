package ru.netology.rest_classw5.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.netology.rest_classw5.domain.Person;

@RestController
public class HelloController {

    @Value("myAppTest")
    private String from;

// Работает для ПОСТ запроса
@PostMapping ("/hello")
private String hello(@RequestBody @Validated Person guest){ // private String hello(@RequestBody Person guest){
    return String.format("Hello from %s to name %s age %s!",
            from, guest.getName(), guest.getAge());
}

// ПОСТ запрос
//    POST http://localhost:8080/hello
//    Content-Type: application/json
//
//    {
//        "name": "Ivan",
//            "age": 3
//    }

// НЕ Работает
//@GetMapping ("/hello")
//private String hello(Person guest){ //
//    return String.format("Hello from %s to name %s age %s!",
//            from, guest.getName(), guest.getAge());
//}
//
    // НЕ Работает
//    @GetMapping ("/hello")
//    private String hello(@RequestBody Person guest){
//        return String.format("Hello from %s to name %s age %s!",
//                from, guest.getName(), guest.getAge());
//    }

//    // Работает для ГЕТ запрос
//    @GetMapping ("/hello")
//    private String hello(@RequestParam("name") String name,
//                         @RequestParam("age") String age){
//        return String.format("Hello from %s to name %s age %s!",
//                from, name, age);
//    }

    // ГЕТ запрос
//GET http://localhost:8080/hello?name=Oleg&age=33
  //  Accept: application/json


}
