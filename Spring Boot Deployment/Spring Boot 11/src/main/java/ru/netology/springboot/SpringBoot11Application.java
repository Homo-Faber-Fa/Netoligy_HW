package ru.netology.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class SpringBoot11Application {

	public static void main(String[] args) {

		SpringApplication.run(SpringBoot11Application.class, args);
	}

}
