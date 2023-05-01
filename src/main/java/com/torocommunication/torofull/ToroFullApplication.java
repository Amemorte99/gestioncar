package com.torocommunication.torofull;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class ToroFullApplication {






	public static void main(String[] args) {
		SpringApplication.run(ToroFullApplication.class, args);
	}




}
