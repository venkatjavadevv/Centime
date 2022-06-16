package com.centime.service.app.module.service.impl;

import org.springframework.stereotype.Service;

import com.centime.service.app.module.service.core.SecondService;


@Service
public class SecondServiceImpl implements SecondService{


	@Override
	public String fetchHello() {
		
		return "hello";
	}
	


}
