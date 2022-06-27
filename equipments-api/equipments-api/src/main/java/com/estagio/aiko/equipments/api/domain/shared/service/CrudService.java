package com.estagio.aiko.equipments.api.domain.shared.service;

import java.util.List;

public interface CrudService<T, ID> {

	T create(T object);

	List<T> findAll();

	T findById(ID id);

	T update(ID id, T object);

	void delete(ID id);

}
