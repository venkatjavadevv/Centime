package com.centime.service.app.module.service.response;

import java.util.ArrayList;
import java.util.List;

public class ErrorResponse {

	private String domain;
	private String code;
	private int status;
	private String debugMessage;
	private String clientMessage;
	private String moreInfoLink;
	private List<ErrorResponse> errors = new ArrayList<ErrorResponse>();

	
	public ErrorResponse() {
	}

	
	public ErrorResponse(String domain, String code, int status, String debugMessage, String clientMessage,
			String moreInfoLink,List<ErrorResponse> errors) {
		this.domain = domain;
		this.code = code;
		this.status = status;
		this.debugMessage = debugMessage;
		this.clientMessage = clientMessage;
		this.moreInfoLink = moreInfoLink;
		this.errors=errors;
	}
	
	public ErrorResponse(String domain, String code, int status, String debugMessage, String clientMessage,
			String moreInfoLink) {
		this.domain = domain;
		this.code = code;
		this.status = status;
		this.debugMessage = debugMessage;
		this.clientMessage = clientMessage;
		this.moreInfoLink = moreInfoLink;
	}

	
	public ErrorResponse(String domain, String code, int status, String debugMessage, String clientMessage) {
		this.domain = domain;
		this.code = code;
		this.status = status;
		this.debugMessage = debugMessage;
		this.clientMessage = clientMessage;
	}

	@Override
	public String toString() {
		return "{\"" + (domain != null ? "domain\":\"" + domain + "\",\"" : "")
				+ (code != null ? "code\":\"" + code + "\",\"" : "") + "status\":" + status + ",\""
				+ (debugMessage != null ? "debugMessage\":\"" + debugMessage + "\",\"" : "")
				+ (clientMessage != null ? "clientMessage\":\"" + clientMessage + "\",\"" : "")
				+ (moreInfoLink != null ? "moreInfoLink\":\"" + moreInfoLink + "\",\"" : "")
				+ (errors != null ? "errors\":" + errors : "") + "}";
	}

	public String getDomain() {
		return domain;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getDebugMessage() {
		return debugMessage;
	}

	public void setDebugMessage(String debugMessage) {
		this.debugMessage = debugMessage;
	}

	public String getClientMessage() {
		return clientMessage;
	}

	public void setClientMessage(String clientMessage) {
		this.clientMessage = clientMessage;
	}

	public String getMoreInfoLink() {
		return moreInfoLink;
	}

	public void setMoreInfoLink(String moreInfoLink) {
		this.moreInfoLink = moreInfoLink;
	}

	public List<ErrorResponse> getErrors() {
		return errors;
	}

	public void setErrors(List<ErrorResponse> errors) {
		this.errors = errors;
	}
}