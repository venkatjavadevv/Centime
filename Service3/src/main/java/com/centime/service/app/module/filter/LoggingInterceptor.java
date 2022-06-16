package com.centime.service.app.module.filter;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

@Component
public class LoggingInterceptor extends HandlerInterceptorAdapter {

	private static final Logger LOGGER = LoggerFactory.getLogger(LoggingInterceptor.class);

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		long startTime = System.currentTimeMillis();
		LOGGER.info("Request URL: " + request.getRequestURL());
		LOGGER.info("Start Time: " + System.currentTimeMillis());

		request.setAttribute("startTime", startTime);
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, 
			Object handler, ModelAndView modelAndView) throws Exception {

		StringBuilder sb = new StringBuilder();

		sb.append("!Status: "+response.getStatus()+"\n");
		sb.append("!URL: "+ request.getRequestURL());
		sb.append("!Method: " + request.getMethod() + "\n");
		LOGGER.info(sb.toString());

	}
	
	 @Override
	 public void afterCompletion(HttpServletRequest request, HttpServletResponse response, 
	        Object object, Exception arg3)
	        throws Exception {
	    System.out.println("afterCompletion Request Completed");
	 }

}