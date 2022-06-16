package com.centime.service.app.module.service.core;

import java.util.List;

import com.centime.service.app.module.model.CustomEntity;
import com.centime.service.app.module.response.CustomEntityResponse;

public interface CustomEntityService {

	public List<CustomEntityResponse> fetchEntities();
	
	public CustomEntity fetchEntity(Long id);

}
