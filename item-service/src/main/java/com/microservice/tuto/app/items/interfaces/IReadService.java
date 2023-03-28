package com.microservice.tuto.app.items.interfaces;

import java.util.List;

public interface IReadService<Entity> {

	public List<Entity> findAll();

	public Entity findById(long id, Integer quantity);

}
