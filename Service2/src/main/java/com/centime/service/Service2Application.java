package com.centime.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
//import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


//@EnableDiscoveryClient
@SpringBootApplication(scanBasePackages={"com.centime.service"})
public class Service2Application extends SpringBootServletInitializer{

	public static void main(String[] args) {
		SpringApplication.run(Service2Application.class, args);
	}

}
