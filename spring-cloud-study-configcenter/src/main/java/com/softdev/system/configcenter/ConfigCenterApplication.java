package com.softdev.system.configcenter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@EnableConfigServer
@SpringBootApplication
public class ConfigCenterApplication {
	public static void main(String[] args) {
		SpringApplication.run(ConfigCenterApplication.class,args);
	}
}
