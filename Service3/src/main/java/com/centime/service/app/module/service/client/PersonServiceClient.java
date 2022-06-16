/*
 * package com.centime.service.app.module.service.client;
 * 
 * import org.springframework.core.ParameterizedTypeReference; import
 * org.springframework.http.HttpEntity; import
 * org.springframework.http.HttpMethod; import
 * org.springframework.http.ResponseEntity; import
 * org.springframework.web.client.RestTemplate;
 * 
 * import com.centime.service.app.module.service.core.PersonService; import
 * com.centime.service.app.module.service.request.Person; import
 * com.centime.service.app.module.service.response.PersonResponse;
 * 
 * public class PersonServiceClient implements PersonService {
 * 
 * @Override public PersonResponse concatNames(Person person) { // final String
 * REST_URI = NextLibraryUrls.SERVER_URL + NextLibraryUrls.HELLO_URL; final
 * String REST_URI = "http://localhost:8083/service-3/hello/hello"; final
 * RestTemplate restTemplate = new RestTemplate(); final HttpEntity<Object>
 * requestEntity = new HttpEntity<Object>(null);
 * 
 * final ResponseEntity<PersonResponse> responseEntity =
 * restTemplate.exchange(REST_URI, HttpMethod.POST, requestEntity, new
 * ParameterizedTypeReference<PersonResponse>() { }); return
 * responseEntity.getBody(); } }
 */