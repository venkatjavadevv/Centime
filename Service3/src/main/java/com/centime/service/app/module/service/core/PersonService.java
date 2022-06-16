package com.centime.service.app.module.service.core;

import com.centime.service.app.module.service.request.Person;
import com.centime.service.app.module.service.response.PersonResponse;

public interface PersonService {

	public String fetchHello();
	
	public PersonResponse concatNames(Person person);


}
