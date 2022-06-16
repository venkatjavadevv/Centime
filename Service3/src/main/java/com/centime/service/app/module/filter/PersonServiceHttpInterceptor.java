package com.centime.service.app.module.filter;

import java.io.IOException;
import java.nio.charset.Charset;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.util.StreamUtils;


@Configuration
public class PersonServiceHttpInterceptor implements ClientHttpRequestInterceptor{
	@Override
	public ClientHttpResponse intercept(HttpRequest httpRequest, byte[] body, ClientHttpRequestExecution execution)                 throws IOException {
		printRequest(httpRequest, body);
		ClientHttpResponse response = execution.execute(httpRequest, body);
		printResponse(response);
		return response;
	}

	private void printRequest(HttpRequest httpRequest, byte[] body) throws IOException {            
		System.out.println("URI         = "+ httpRequest.getURI());            
		System.out.println("Method      = "+ httpRequest.getMethod());
		System.out.println("Headers     = "+ httpRequest.getHeaders());
		System.out.println("Request body= "+ new String(body, "UTF-8"));
	}

	private void printResponse(ClientHttpResponse response) throws IOException {           
		System.out.println("Status code  = " + response.getStatusCode());
		System.out.println("Status text  = "+ response.getStatusText());
		System.out.println("Headers      = "+ response.getHeaders());
		System.out.println("Response body= "+ StreamUtils.copyToString(response.getBody(), Charset.defaultCharset()));

	}
}