package com.brunopereira.projetoaiko.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.brunopereira.projetoaiko.entities.ValuePerHour;
import com.brunopereira.projetoaiko.repositores.ValuePerHourRepository;
import com.brunopereira.projetoaiko.service.exceptions.DatabaseException;
import com.brunopereira.projetoaiko.service.exceptions.ResourceNotFoundException;

@Service
public class ValuePerHourService {
	
	@Autowired
	private ValuePerHourRepository repository;

	public List<ValuePerHour> findAll() {
		return repository.findAll();
	}
	
	public ValuePerHour findById(Long id) {
		
		return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
	}

	public ValuePerHour insert(ValuePerHour obj) {
		return repository.save(obj);
	}

	public ValuePerHour update(Long id, ValuePerHour obj) {
		
		return repository.findById(id).map(valuePerHour -> {
			valuePerHour.setEquipmentModel(obj.getEquipmentModel());
			valuePerHour.setEquipmentState(obj.getEquipmentState());
			valuePerHour.setValue(obj.getValue());
			
			return repository.save(valuePerHour);
		}).orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	public void delete (Long id) {
		try {
		repository.deleteById(id);
		
		} catch (EmptyResultDataAccessException e) {
			
			throw new ResourceNotFoundException(id);
		} catch (DataIntegrityViolationException e) {
			
			throw new DatabaseException(e.getMessage());
		}
	}

}
