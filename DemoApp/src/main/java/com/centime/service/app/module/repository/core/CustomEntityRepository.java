package com.centime.service.app.module.repository.core;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.centime.service.app.module.model.CustomEntity;

@Repository
public interface CustomEntityRepository extends JpaRepository<CustomEntity, Long>{

	public Optional<CustomEntity> findById(Long id);
	
	public List<CustomEntity> findAll();
		
	
}
