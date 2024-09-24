package ru.netology.rest_classw5.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.netology.rest_classw5.domain.Person;

@RestController
@RequestMapping("/another")
public class AnotherBrokenController {

    @GetMapping("/iae")
    public String throwException() {
        throw new IllegalArgumentException("throwExeption");
    }

//    @ExceptionHandler(RuntimeException.class)
//    public ResponseEntity<String> reHandler(RuntimeException e) {
//        return new ResponseEntity<>("Exception in throwException method", HttpStatus.I_AM_A_TEAPOT);
//    }
}
