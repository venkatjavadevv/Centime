package com.centime.service.app.module.service.exception;

import java.util.Iterator;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.hibernate.validator.internal.engine.path.PathImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

import com.centime.service.app.module.service.response.ErrorResponse;


@Provider
public class AppExceptionMapper implements ExceptionMapper<Exception> {

	@Autowired
	ReloadableResourceBundleMessageSource messageSource;

	@Override
	public Response toResponse(Exception exception) {
//		Logger.i("Exception!", exception);
		exception.printStackTrace();
		CustomClientExceptionBuilder builder=new CustomClientExceptionBuilder();
		ErrorResponse errorResponse = null;
		if (exception instanceof CustomClientException) {
			errorResponse = builder.exceptionToResponse((CustomClientException) exception);
		} else if (exception instanceof ConstraintViolationException) {
			ConstraintViolationException exce = (ConstraintViolationException) exception;
			Set<ConstraintViolation<?>> set = exce.getConstraintViolations();
			CustomException ex = new CustomException("Service3", "validationFailed", 400,
					"Provided data does not match constraints", "Validation failed.");
			for (Iterator<ConstraintViolation<?>> iterator = set.iterator(); iterator.hasNext();) {
				ConstraintViolation<?> next = iterator.next();
				String devMsg = next.getPropertyPath() + "|" + next.getMessage();
				String clientMsg = ((PathImpl) next.getPropertyPath()).getLeafNode().getName() + "|"
						+ next.getMessage();
				CustomException e = new CustomException("Service3", "validationFailed", 400, devMsg, clientMsg);
				ex.addException(e);
			}
			errorResponse = builder.exceptionToResponse(ex);
		} else {
			CustomException ex = new CustomException("Service3", "serverInternalError", 500,
					exception.getMessage(), "Something goes wrong.");
			errorResponse = builder.exceptionToResponse(ex);
		}
		return Response.status(Status.fromStatusCode(errorResponse.getStatus())).entity(errorResponse.toString())
				.type(MediaType.APPLICATION_JSON).build();
	}

}