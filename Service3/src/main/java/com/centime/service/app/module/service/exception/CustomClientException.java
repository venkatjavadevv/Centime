package com.centime.service.app.module.service.exception;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class CustomClientException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	protected String domain;
	protected String code;
	protected int status;
	protected String debugMessage;
	protected String clientMessage;
	protected String moreInfoLink;
	protected List<CustomClientException> errors = new ArrayList<CustomClientException>();


	public CustomClientException() {
		super();
	}
	
	
	public CustomClientException(Throwable t, String domain, String code, int status, String debugMessage,
			String clientMessage) {
		super(t);
		this.domain = domain;
		this.code = code;
		this.status = status;
		this.debugMessage = debugMessage;
		this.clientMessage = clientMessage;
	}

	
	public CustomClientException(Throwable t, String domain, String code, int status, String debugMessage,
			String clientMessage, String moreInfoLink) {
		super(t);
		this.domain = domain;
		this.code = code;
		this.status = status;
		this.debugMessage = debugMessage;
		this.clientMessage = clientMessage;
		this.moreInfoLink = moreInfoLink;
	}

	
	public CustomClientException(String domain, String code, int status, String debugMessage,
			String clientMessage) {
		this.domain = domain;
		this.code = code;
		this.status = status;
		this.debugMessage = debugMessage;
		this.clientMessage = clientMessage;
	}

	public CustomClientException(String domain, String code, int status, String debugMessage,
			String clientMessage, String moreInfoLink) {
		this.domain = domain;
		this.code = code;
		this.status = status;
		this.debugMessage = debugMessage;
		this.clientMessage = clientMessage;
		this.moreInfoLink = moreInfoLink;
	}

	public void addException(CustomClientException exception) {
		this.errors.add(exception);
	}

	public String getDomain() {
		return domain;
	}

	public String getCode() {
		return code;
	}

	public int getStatus() {
		return status;
	}

	public String getDebugMessage() {
		return debugMessage;
	}

	public String getClientMessage() {
		return clientMessage;
	}

	public String getMoreInfoLink() {
		return moreInfoLink;
	}

	public List<CustomClientException> getErrors() {
		return errors;
	}

	@JsonIgnore
	@Override
	public synchronized Throwable getCause() {
		return super.getCause();
	}

	@JsonIgnore
	@Override
	public StackTraceElement[] getStackTrace() {
		return super.getStackTrace();
	}

	@JsonIgnore
	@Override
	public String getLocalizedMessage() {
		return super.getLocalizedMessage();
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public void setDebugMessage(String debugMessage) {
		this.debugMessage = debugMessage;
	}

	public void setClientMessage(String clientMessage) {
		this.clientMessage = clientMessage;
	}

	public void setMoreInfoLink(String moreInfoLink) {
		this.moreInfoLink = moreInfoLink;
	}

	public void setErrors(List<CustomClientException> errors) {
		this.errors = errors;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(getClass().getName());
		builder.append(" {\n\t");
		if (domain != null) {
			builder.append("domain: ");
			builder.append(domain);
			builder.append("\n\t");
		}
		if (code != null) {
			builder.append("code: ");
			builder.append(code);
			builder.append("\n\t");
		}
		builder.append("status: ");
		builder.append(status);
		builder.append("\n\t");
		if (debugMessage != null) {
			builder.append("debugMessage: ");
			builder.append(debugMessage);
			builder.append("\n\t");
		}
		if (clientMessage != null) {
			builder.append("clientMessage: ");
			builder.append(clientMessage);
			builder.append("\n\t");
		}
		if (moreInfoLink != null) {
			builder.append("moreInfoLink: ");
			builder.append(moreInfoLink);
			builder.append("\n\t");
		}
		if (errors != null && !errors.isEmpty()) {
			builder.append("errors: ");
			builder.append(errors);
		}
		builder.append("\n}");
		return builder.toString();
	}

}