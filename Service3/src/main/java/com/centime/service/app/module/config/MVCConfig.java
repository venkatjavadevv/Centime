package com.centime.service.app.module.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@EnableWebMvc
public class MVCConfig extends WebMvcConfigurerAdapter {

	@Bean
	public ReloadableResourceBundleMessageSource messageSource() {
//		LogMessage.info("MvcConfig.messageSource()");
		ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
		messageSource.setBasename("classpath:application.properties");
		messageSource.setCacheSeconds(10); // reload messages every 10 seconds
		return messageSource;
	}
}
