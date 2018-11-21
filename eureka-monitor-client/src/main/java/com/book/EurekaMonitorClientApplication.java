package com.book;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class EurekaMonitorClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaMonitorClientApplication.class, args);
	}
}
