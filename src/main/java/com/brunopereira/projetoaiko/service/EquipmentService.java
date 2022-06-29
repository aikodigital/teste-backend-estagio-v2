 package com.brunopereira.projetoaiko.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.orm.jpa.JpaObjectRetrievalFailureException;
import org.springframework.stereotype.Service;

import com.brunopereira.projetoaiko.entities.Equipment;
import com.brunopereira.projetoaiko.repositores.EquipmentRepository;
import com.brunopereira.projetoaiko.service.exceptions.DatabaseException;
import com.brunopereira.projetoaiko.service.exceptions.ModelNotFoundException;
import com.brunopereira.projetoaiko.service.exceptions.ResourceNotFoundException;

@Service
public class EquipmentService {

	@Autowired
	private EquipmentRepository repository;

	public List<Equipment> findAll() {
		return repository.findAll();
	}

	public Equipment findById(Long id) {

		return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
	}

	public Equipment insert(Equipment obj) {
		
			try {
				return repository.save(obj);
				
			} catch (JpaObjectRetrievalFailureException e) {
				throw new ModelNotFoundException();
			
			}
			
			//JpaObjectRetrievalFailureException
	
		
	}

	public Equipment update(Long id, Equipment obj) {

		return repository.findById(id).map(equipment -> {
			equipment.setName(obj.getName());
			equipment.setEquipmentModel(obj.getEquipmentModel());
			return repository.save(equipment);
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
