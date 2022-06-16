package com.centime.service.app.module.service.exception;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.centime.service.app.module.service.response.ErrorResponse;

@Mapper(componentModel = "spring")
public interface CustomClientExceptionMapper {
	CustomClientExceptionMapper INSTANCE = Mappers.getMapper(CustomClientExceptionMapper.class);

	ErrorResponse exceptionToResponse(CustomClientException exception);

	List<ErrorResponse> exceptionToResponse(List<CustomClientException> exception);

	CustomClientException responseToException(ErrorResponse exception);

	List<CustomClientException> responseToException(List<ErrorResponse> exception);

}
