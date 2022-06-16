package com.centime.service.app.module.config;

import javax.annotation.PostConstruct;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.RequestContextFilter;

import com.centime.service.app.module.filter.PersonServiceHttpInterceptor;
import com.centime.service.app.module.service.exception.AppExceptionMapper;

import io.swagger.jaxrs.config.BeanConfig;
import io.swagger.jaxrs.listing.ApiListingResource;
import io.swagger.jaxrs.listing.SwaggerSerializers;

@Component
public class JerseyConfig extends ResourceConfig {

	@PostConstruct
	public void init() { // Register components where DI is needed
		this.configureSwagger();
	}

	private void configureSwagger() {
		this.register(ApiListingResource.class);
		this.register(SwaggerSerializers.class);

		BeanConfig config = new BeanConfig();
		config.setConfigId("service-3");
		config.setTitle("service-3");
		config.setVersion("v1.0.0");
		config.setSchemes(new String[] { "http", "https" });
		config.setBasePath("service-1");
		config.setResourcePackage("com.centime.service.app.module.controller");
		config.setPrettyPrint(false);
		config.setScan(true);
		config.setHost("localhost:8083");
	}

	public JerseyConfig() {
		System.out.println("jersey config");
		register(RequestContextFilter.class);
		packages("com.centime.service.app.module.controller");
		packages("com.centime.service.app.module.service.response");
		register(AppExceptionMapper.class);
		register(PersonServiceHttpInterceptor.class);
		register(LoggingConfiguation.class);
	}

	/*
	 * @Bean public ReloadableResourceBundleMessageSource messageSource() { //
	 * LogMessage.info("MvcConfig.messageSource()");
	 * ReloadableResourceBundleMessageSource messageSource = new
	 * ReloadableResourceBundleMessageSource(); //
	 * messageSource.setBasename("classpath:config.properties");
	 * messageSource.setCacheSeconds(10); // reload messages every 10 seconds return
	 * messageSource; }
	 */
	/*
	 * @Bean public ServletRegistrationBean jerseyServlet() {
	 * ServletRegistrationBean registration = new ServletRegistrationBean(new
	 * ServletContainer(), "/service-3/*"); // Rest resources will be available in
	 * the path /NextCalendar/*
	 * registration.addInitParameter(ServletProperties.JAXRS_APPLICATION_CLASS,
	 * JerseyConfig.class.getName()); registration.setLoadOnStartup(1);
	 * registration.setName("jersey-servlet"); return registration; }
	 */
}
