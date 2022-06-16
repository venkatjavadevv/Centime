package com.centime.service.app.module.service.impl;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.centime.service.app.module.service.core.PersonService;
import com.centime.service.app.module.service.request.Person;
import com.centime.service.app.module.service.response.PersonResponse;

@Service
public class PersonServiceImpl implements PersonService {

	@Override
	public String fetchHello() {
		
		return "hello";
	}
	
	@Override
	public PersonResponse concatNames(Person person) {

		Optional<Person> optional = Optional.of(person);

		if (optional.isEmpty() || Optional.ofNullable(optional.get().getName()).isEmpty()
				|| Optional.ofNullable(optional.get().getSurName()).isEmpty()) {
			// throw new Exception
		}

		PersonResponse response = new PersonResponse();
		response.setFullName(person.getName() + " " + person.getSurName());

		return response;
	}

	
}
