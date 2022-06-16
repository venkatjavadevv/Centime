package com.centime.service.app.module.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import com.centime.service.app.module.model.CustomEntity;
import com.centime.service.app.module.response.CustomEntityResponse;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public abstract class CustomEntityMapper {

	abstract CustomEntityResponse CustomEntityToCustomEntityResponse(CustomEntity customEntity);
	
}
