package com.centime.service.app.module.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.centime.service.app.module.client.PersonServiceClient;
import com.centime.service.app.module.client.Service2Client;
import com.centime.service.app.module.request.PersonRequest;
import com.centime.service.app.module.response.JerseyResponse;
import com.centime.service.app.module.response.PersonResponse;
import com.centime.service.app.module.service.core.FirstService;

@Service
public class FirstServiceImpl implements FirstService {

	@Autowired
	private PersonServiceClient personServiceClient;

	@Autowired
	private Service2Client service2Client;
	
	@Override
	public JerseyResponse getStatus() {
		JerseyResponse response = new JerseyResponse();
		response.setCode("200");
		response.setMsg("UP");

		return response;
	}

	@Override
	public PersonResponse concateResponse(PersonRequest personRequest) {

		
		 String response1 = service2Client.fetchHello();
		 System.out.println(response1);
		ResponseEntity<PersonResponse> response = (ResponseEntity<PersonResponse>) personServiceClient.concatNames(personRequest);
		return null;
	}

}
