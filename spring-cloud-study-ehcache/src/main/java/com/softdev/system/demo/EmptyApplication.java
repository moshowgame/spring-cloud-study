package com.softdev.system.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class EmptyApplication {
	public static void main(String[] args) {
		SpringApplication.run(EmptyApplication.class,args);
	}
}
