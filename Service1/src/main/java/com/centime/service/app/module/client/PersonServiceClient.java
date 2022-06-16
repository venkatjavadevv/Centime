package com.centime.service.app.module.client;

import java.net.URI;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.centime.service.app.module.request.PersonRequest;

@Component
public class PersonServiceClient {
	
	@Autowired
	private RestTemplate restTemplate;

	public ResponseEntity<?> concatNames(PersonRequest personRequest) {
		
		RestTemplate restTemplate = new RestTemplate();
		String baseUrl="http://localhost:8083/service-3/person/concat-names";
		URI uri = null;
		try {
			uri = new URI(baseUrl);
			
			
			ResponseEntity<String> result = restTemplate.postForEntity(uri, personRequest, String.class);

//			return new ResponseEntity<>(result, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
//			return new ResponseEntity<>("Error!, Please try again", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		
		  HttpHeaders headers = new HttpHeaders();
		  headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON)); HttpEntity
		  <String> entity = new HttpEntity<String>(headers);
		  
		  Object str = restTemplate.exchange(uri, HttpMethod.GET, entity, Object.class).getBody(); 
		  return null;
		 
		  
		
		/*String uri="http://localhost:8083/service-3/person/concat-names";
//		final RestTemplate restTemplate = new RestTemplate();
//		restTemplate.setErrorHandler(responseErrorHandler);
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
//		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		final HttpEntity<Object> requestEntity = new HttpEntity<Object>(personRequest, headers);
//		List<Object> objects = Arrays.asList(sessionParams, queryable);
		ResponseEntity<PersonResponse> responseEntity = restTemplate.exchange(uri, HttpMethod.POST, requestEntity,
				new ParameterizedTypeReference<PersonResponse>() {
				});
		PersonResponse response =  responseEntity.getBody();
		return null;
		*/

		
//		String uri="http://localhost:8083/service-3/person/concat-names";
		
//		String uri="http://localhost:8083/service-3/person/concat-names";

	/*	 
		
		  HttpHeaders headers = new HttpHeaders();
		  headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		  
		  // HttpEntity <PersonRequest> entity = new
		  HttpEntity<PersonRequest>(personRequest,headers); HttpEntity <PersonRequest>
		  entity = new HttpEntity<PersonRequest>(headers);
		  
		  PersonResponse response = restTemplate.exchange(uri, HttpMethod.POST, entity,
		  PersonResponse.class).getBody(); 
		  return null;
		  */
		 
		
				/*
				 * HttpHeaders headers = new HttpHeaders();
				 * headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON)); HttpEntity
				 * <String> entity = new HttpEntity<String>(headers);
				 * 
				 * PersonResponse str = restTemplate.exchange(uri, HttpMethod.GET, entity,
				 * PersonResponse.class).getBody(); return null;
				 */
	}
}

