package com.centime.service.app.module.client;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class Service2Client {

	@Autowired
	private RestTemplate restTemplate;

	public String fetchHello() {

		String uri="http://localhost:8082/service-2/second/hello";

		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON)); 
		HttpEntity<String> entity = new HttpEntity<String>(headers);

		String response = restTemplate.exchange(uri, HttpMethod.GET, entity,
				String.class).getBody(); 
		return response;

	}
	}
