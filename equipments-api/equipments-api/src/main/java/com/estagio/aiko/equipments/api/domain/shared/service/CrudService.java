package com.estagio.aiko.equipments.api.domain.shared.service;

import java.util.List;

public interface CrudService<T, ID> {

	T create(T object);

	T update(ID id, T object);

	List<T> findAll();

	T findById(ID id);

	void delete(ID id);

}
