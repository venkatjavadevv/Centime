package com.centime.service.app.module.controller;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;

import com.centime.service.app.module.request.PersonRequest;
import com.centime.service.app.module.response.JerseyResponse;
import com.centime.service.app.module.response.PersonResponse;
import com.centime.service.app.module.service.core.FirstService;
import com.centime.service.app.module.service.util.Constants;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Path(Constants.URL_CONTROLLER)
@Produces(MediaType.APPLICATION_JSON)
@Api(value = "First Controller", produces = "application/json")
public class FirstController {
	
	@Autowired
	private FirstService firstService;
	
	@GET
	@Path(Constants.URL_STATUS)
	@ApiOperation(value = "Gets a Hello Resource", response = JerseyResponse.class)
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Hello resource found"),
        @ApiResponse(code = 404, message = "Hello resource not found")
    })
	public JerseyResponse getStatus() {
		return firstService.getStatus();
	}
	
	@POST
	@Path(Constants.URL_CONCATE_NAMES)
	@ApiOperation(value = "Gets a Concatinated Resource ", response = JerseyResponse.class)
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Concat resource found"),
        @ApiResponse(code = 404, message = "Concat resource not found")
    })
	public PersonResponse concateResponse(PersonRequest personRequest) {
		return firstService.concateResponse(personRequest);
	}

}
