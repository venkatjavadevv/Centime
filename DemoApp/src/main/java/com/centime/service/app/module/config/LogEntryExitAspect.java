package com.centime.service.app.module.config;

import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.springframework.boot.logging.LogLevel;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogEntryExitAspect {

	 static void log(Logger logger, LogLevel level, String message) {
		    switch (level) {
		      case DEBUG : logger.debug(message);
		      case TRACE : logger.trace(message);
		      case WARN : logger.warn(message);
		      case ERROR: 
		    	  logger.error(message);
		      case FATAL :
		    	  logger.error(message);
		      default : logger.info(message);
		    }
		  }
}
