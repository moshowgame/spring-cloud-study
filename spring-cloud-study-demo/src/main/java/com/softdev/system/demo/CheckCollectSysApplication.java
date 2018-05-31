package com.softdev.system.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class CheckCollectSysApplication {
	public static void main(String[] args) {
		SpringApplication.run(CheckCollectSysApplication.class,args);
		System.out.println("http://127.0.0.1:8094/xy/port/initCom?comCode=COM3");
		System.out.println("http://127.0.0.1:8094/xy/port/writeCom?comData=XXXXYYYZZZ");
		System.out.println("http://127.0.0.1:8094/xy/port/getDataFromCom");
		System.out.println("http://127.0.0.1:8094/xy/port/startScan");
		System.out.println("http://127.0.0.1:8094/xy/port/stopScan");
		System.out.println("http://127.0.0.1:8094/xy/port/putdata");
	}
}
