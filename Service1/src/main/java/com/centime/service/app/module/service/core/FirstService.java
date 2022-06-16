package com.centime.service.app.module.service.core;

import com.centime.service.app.module.request.PersonRequest;
import com.centime.service.app.module.response.JerseyResponse;
import com.centime.service.app.module.response.PersonResponse;

public interface FirstService {

	public JerseyResponse getStatus() ;
	
	public PersonResponse concateResponse(PersonRequest personRequest) ;
}
