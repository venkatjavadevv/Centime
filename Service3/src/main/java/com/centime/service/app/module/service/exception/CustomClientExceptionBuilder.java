package com.centime.service.app.module.service.exception;

import java.util.ArrayList;
import java.util.List;

import com.centime.service.app.module.service.response.ErrorResponse;

public class CustomClientExceptionBuilder {

	public ErrorResponse exceptionToResponse(CustomClientException exception) {
		if (exception == null) {
			return null;
		}

		ErrorResponse errorResponse = new ErrorResponse();

		errorResponse.setDomain(exception.getDomain());
		errorResponse.setCode(exception.getCode());
		errorResponse.setStatus(exception.getStatus());
		errorResponse.setDebugMessage(exception.getDebugMessage());
		errorResponse.setClientMessage(exception.getClientMessage());
		errorResponse.setMoreInfoLink(exception.getMoreInfoLink());
		errorResponse.setErrors(exceptionToResponse(exception.getErrors()));

		return errorResponse;
	}

	public List<ErrorResponse> exceptionToResponse(List<CustomClientException> exception) {
		if (exception == null) {
			return null;
		}

		List<ErrorResponse> list_ = new ArrayList<ErrorResponse>();
		for (CustomClientException customServiceClientException : exception) {
			list_.add(exceptionToResponse(customServiceClientException));
		}

		return list_;
	}

	public CustomClientException responseToException(ErrorResponse exception) {
		if (exception == null) {
			return null;
		}

		CustomClientException customClientException = new CustomClientException();

		customClientException.setDomain(exception.getDomain());
		customClientException.setCode(exception.getCode());
		customClientException.setStatus(exception.getStatus());
		customClientException.setDebugMessage(exception.getDebugMessage());
		customClientException.setClientMessage(exception.getClientMessage());
		customClientException.setMoreInfoLink(exception.getMoreInfoLink());
		customClientException.setErrors(responseToException(exception.getErrors()));

		return customClientException;
	}

	public List<CustomClientException> responseToException(List<ErrorResponse> exception) {
		if (exception == null) {
			return null;
		}

		List<CustomClientException> list_ = new ArrayList<CustomClientException>();
		for (ErrorResponse errorResponse : exception) {
			list_.add(responseToException(errorResponse));
		}

		return list_;
	}
}
