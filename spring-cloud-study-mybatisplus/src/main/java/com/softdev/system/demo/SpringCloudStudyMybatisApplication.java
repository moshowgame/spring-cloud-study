package com.softdev.system.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@EnableEurekaClient
@SpringBootApplication
public class SpringCloudStudyMybatisApplication {
	public static void main(String[] args) {
		SpringApplication.run(SpringCloudStudyMybatisApplication.class,args);
		System.out.println("http://127.0.0.1:3333/mybatisplus/user/init");
		System.out.println("http://127.0.0.1:3333/mybatisplus/user/find");
	}
}
