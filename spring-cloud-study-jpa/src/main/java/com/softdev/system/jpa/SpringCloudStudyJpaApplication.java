package com.softdev.system.jpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

//@EnableEurekaClient
@SpringBootApplication
public class SpringCloudStudyJpaApplication {
	public static void main(String[] args) {
		SpringApplication.run(SpringCloudStudyJpaApplication.class,args);
		System.out.println("http://127.0.0.1:4444/jpa/user/init");
		System.out.println("http://127.0.0.1:4444/jpa/user/9999");
		System.out.println("http://127.0.0.1:4444/jpa/user/roles/9999");
	}
}
