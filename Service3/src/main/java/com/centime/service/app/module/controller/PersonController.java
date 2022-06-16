package com.centime.service.app.module.controller;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;

import com.centime.service.app.module.service.core.PersonService;
import com.centime.service.app.module.service.request.Person;
import com.centime.service.app.module.service.response.PersonResponse;

@Path("/person")
@Produces(MediaType.APPLICATION_JSON)
public class PersonController {
	
	@Autowired
	private PersonService personService;
	
	@GET
	public String fetchHello() {
	
		return personService.fetchHello();
	}
	
	@POST	
	@Path("/concat-names")
	public PersonResponse concatNames(Person person) {
		return personService.concatNames(person);
	}

}
