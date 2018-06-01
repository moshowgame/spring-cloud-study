package com.softdev.system.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class SpringCloudStudyDemoApplication {
	public static void main(String[] args) {
		SpringApplication.run(SpringCloudStudyDemoApplication.class,args);
		System.out.println("http://127.0.0.1:9999/demosocket/222");
		System.out.println("http://127.0.0.1:9999/demo/socket/222");
		System.out.println("http://127.0.0.1:9999/demo/index");
	}
}
