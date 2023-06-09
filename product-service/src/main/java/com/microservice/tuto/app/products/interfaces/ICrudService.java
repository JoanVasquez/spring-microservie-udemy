package com.microservice.tuto.app.products.interfaces;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

public interface ICrudService<Entity> extends IPaginationResult<Entity> {

	public Entity save(Entity entity);
	
	@Transactional(readOnly = true)
	public List<Entity> findAll();

	@Transactional(readOnly = true)
	public Entity findById(long id);

	public void update(Entity entity, long id);

	public void delete(long id);
	
}
