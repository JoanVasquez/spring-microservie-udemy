package com.microservice.tuto.app.items.interfaces;

import java.util.List;

public interface ICrudService<Entity> {

	public List<Entity> findAll();

	public Entity findById(long id, Integer quantity);
	
	public void update(Entity entity, long id);

	public void delete(long id);

}
