package com.centime.service.app.module.controller;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import com.centime.service.app.module.model.CustomEntity;
import com.centime.service.app.module.response.CustomEntityResponse;
import com.centime.service.app.module.service.core.CustomEntityService;

@Path("/demo")
@Produces(MediaType.APPLICATION_JSON)
public class HelloController {
	
	@Autowired
	private CustomEntityService customEntityService;
	@GET
	@Path("hello")
	public String hello() {
		return "hello";
	}
	
	
	@GET
	@Path("/entities")
	public List<CustomEntityResponse> fetchEntities() {
	
		return customEntityService.fetchEntities();
	}
	
	@GET
	@Path("/entities"+"/{id}")
	public CustomEntity fetchEntity(@PathParam("id") Long id) {
		return customEntityService.fetchEntity(id);
	}

}
