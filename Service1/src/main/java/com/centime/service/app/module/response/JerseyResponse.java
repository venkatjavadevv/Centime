package com.centime.service.app.module.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(value = Include.NON_NULL)
public class JerseyResponse {

	private String code;
	private String msg;
	private Long id;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public JerseyResponse withCode(String code) {
		this.code = code;
		return this;
	}

	public JerseyResponse withMsg(String msg) {
		this.msg = msg;
		return this;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public JerseyResponse withId(long id) {
		this.id = id;
		return this;
	}
}
