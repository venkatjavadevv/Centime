package com.centime.service.app.module.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.centime.service.app.module.model.CustomEntity;
import com.centime.service.app.module.repository.core.CustomEntityRepository;
import com.centime.service.app.module.response.CustomEntityResponse;
import com.centime.service.app.module.service.core.CustomEntityService;

@Service
public class CustomEntityServiceImpl implements CustomEntityService{

	@Autowired
	private CustomEntityRepository customEntityRepository;
	@Override
	public List<CustomEntityResponse> fetchEntities() {
		Map<Long, CustomEntityResponse> parentResponse = null;
		Map<Long, CustomEntityResponse> childResponse = null;
		List<CustomEntity> entityList = null;
		List<CustomEntityResponse> responseList = null;
		
		entityList = customEntityRepository.findAll();

		parentResponse = new HashMap<Long, CustomEntityResponse>();
		childResponse = new HashMap<Long, CustomEntityResponse>();

		for (CustomEntity entity : entityList) {

			CustomEntityResponse customEntityResponse = new CustomEntityResponse();
			customEntityResponse.setName(entity.getName());
			List<CustomEntityResponse> list = new ArrayList<CustomEntityResponse>();
			customEntityResponse.setSubClasses(list);
			CustomEntityResponse parent = null;

			if (entity.getParentId() == 0) {
				parentResponse.put(entity.getId(), customEntityResponse);
			} else {
				if (parentResponse.containsKey(entity.getParentId())) {
					parent = parentResponse.get(entity.getParentId());

				} else {
					parent = childResponse.get(entity.getParentId());
				}
				parent.getSubClasses().add(customEntityResponse);
				childResponse.put(entity.getId(), customEntityResponse);
			}
		}

		 responseList = parentResponse.values().stream().collect(Collectors.toList());
		return responseList;

	}


	@Override
	public CustomEntity fetchEntity(Long id) {
		Optional<CustomEntity> entity = customEntityRepository.findById(id);
		if (entity.isEmpty()) {
			return null;
		}

		return entity.get();
	}




}
