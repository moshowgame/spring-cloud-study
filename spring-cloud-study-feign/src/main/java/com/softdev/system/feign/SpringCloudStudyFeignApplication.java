package com.softdev.system.feign;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableEurekaClient
@EnableFeignClients
@SpringBootApplication
public class SpringCloudStudyFeignApplication {
	public static void main(String[] args) {
		SpringApplication.run(SpringCloudStudyFeignApplication.class,args);
		System.out.println("http://127.0.0.1:6666/feign/remote/demo/222");
	}
}
