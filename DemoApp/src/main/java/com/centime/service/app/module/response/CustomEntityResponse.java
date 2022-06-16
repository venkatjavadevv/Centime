package com.centime.service.app.module.response;

import java.util.List;

public class CustomEntityResponse {

	private String name;
	
	private List<CustomEntityResponse>  subClasses;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<CustomEntityResponse> getSubClasses() {
		return subClasses;
	}
	public void setSubClasses(List<CustomEntityResponse> subClasses) {
		this.subClasses = subClasses;
	}
	
}
