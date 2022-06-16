package com.centime.service.app.module.controller;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.centime.service.app.module.service.core.SecondService;

@Path("/second")
@Produces(MediaType.APPLICATION_JSON)
public class SecondController {
	
	@Autowired
	private SecondService secondService;
	
	@GET
	@Path("hello")
	public ResponseEntity<String> hello() {
		
		String result =  secondService.fetchHello();
		return ResponseEntity.status(HttpStatus.OK)
		        .body(result);
	}

}
