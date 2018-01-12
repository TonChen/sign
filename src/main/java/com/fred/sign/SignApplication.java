package com.fred.sign;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SignApplication {

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(SignApplication.class);
		app.run(args);
	}
}
