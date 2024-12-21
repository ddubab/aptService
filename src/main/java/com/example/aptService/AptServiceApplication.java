package com.example.aptService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class AptServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AptServiceApplication.class, args);
	}

}
