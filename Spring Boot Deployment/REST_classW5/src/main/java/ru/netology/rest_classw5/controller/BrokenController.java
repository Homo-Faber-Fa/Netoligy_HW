package ru.netology.rest_classw5.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import ru.netology.rest_classw5.domain.Person;

import javax.management.relation.RelationNotFoundException;

@RestController
@RequestMapping("/error")
public class BrokenController {

@GetMapping("{id}")
public Person getPersonById(@PathVariable("id") long id) {
    try{throw new IllegalArgumentException("IllegalArgumentException");
    } catch (RuntimeException e){
    throw new ResponseStatusException(HttpStatus.NOT_FOUND, "ResponseStatusException", e);}}


@GetMapping("iae")
public Person throwException() {
    throw new IllegalArgumentException("throwException");// "IllegalArgumentException"
}

@ExceptionHandler(IllegalArgumentException.class)
public ResponseEntity<String> iaeHandler(IllegalArgumentException e) {
return new ResponseEntity<>("Exception in throwException method", HttpStatus.NOT_FOUND);
}

@ExceptionHandler(RuntimeException.class)
public ResponseEntity<String> reHandler(RuntimeException e) {
return new ResponseEntity<>("Exception in throwException method", HttpStatus.I_AM_A_TEAPOT);
}

}
