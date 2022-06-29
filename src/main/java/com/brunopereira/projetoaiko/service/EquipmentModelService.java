package com.brunopereira.projetoaiko.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.brunopereira.projetoaiko.entities.EquipmentModel;
import com.brunopereira.projetoaiko.repositores.EquipmentModelRepository;
import com.brunopereira.projetoaiko.service.exceptions.DatabaseException;
import com.brunopereira.projetoaiko.service.exceptions.ResourceNotFoundException;

@Service
public class EquipmentModelService {

	@Autowired
	private EquipmentModelRepository repository;

	public List<EquipmentModel> findAll() {
		return repository.findAll();
	}
	
	public EquipmentModel findById(Long id) {
		
		return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
	}

	public EquipmentModel insert(EquipmentModel obj) {
		return repository.save(obj);
	}

	public EquipmentModel update(Long id, EquipmentModel obj) {

		return repository.findById(id).map(equipmentModel -> {
			equipmentModel.setId(obj.getId());
			equipmentModel.setName(obj.getName());
			return repository.save(equipmentModel);
		}).orElseThrow(() -> new ResourceNotFoundException(id));

	}

	public void delete(Long id) {
		try {
			repository.deleteById(id);
			
		} catch (EmptyResultDataAccessException e) {

			throw new ResourceNotFoundException(id);
		} catch (DataIntegrityViolationException e) {

			throw new DatabaseException(e.getMessage());
		}
	}

}
