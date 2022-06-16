package com.centime.service.app.module.filter;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.time.temporal.ChronoUnit;

import org.springframework.boot.logging.LogLevel;

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface LogMethodParam {

	LogLevel value() default LogLevel.INFO;
	 boolean showArgs() default false;
	 boolean showResult() default false;
	 ChronoUnit unit() default ChronoUnit.SECONDS;
	 boolean showExecutionTime() default true;
	
}
