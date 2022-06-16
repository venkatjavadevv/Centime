package com.centime.service.app.module.config;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

@Component
public class JerseyConfig extends ResourceConfig{

	
	public JerseyConfig() {
		System.out.println("jersey config");
		packages("com.centime.service.app.module.controller");
	}
}
