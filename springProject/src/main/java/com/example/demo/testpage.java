package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class testpage {

	@RequestMapping("/")
	public String index() {
		return "Hello World! hj my";
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SpringApplication.run(testpage.class, args);

	}

}
