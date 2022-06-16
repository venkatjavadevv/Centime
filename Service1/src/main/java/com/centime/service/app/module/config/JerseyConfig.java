package com.centime.service.app.module.config;

import org.glassfish.jersey.logging.LoggingFeature;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

import com.centime.service.app.module.service.exception.AppExceptionMapper;


@Component
public class JerseyConfig extends ResourceConfig{

	public JerseyConfig() {
		packages("com.centime.service.app.module.controller");
		register(SwaggerConfig.class);
		register(LoggingFeature.class); 
		register(AppExceptionMapper.class);
		register(CentimeLoggingFilter.class);
	}

}
