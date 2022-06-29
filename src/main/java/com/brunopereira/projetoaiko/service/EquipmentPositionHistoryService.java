package com.brunopereira.projetoaiko.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.brunopereira.projetoaiko.entities.EquipmentPositionHistory;
import com.brunopereira.projetoaiko.repositores.EquipmentPositionHistoryRepository;
import com.brunopereira.projetoaiko.service.exceptions.DatabaseException;
import com.brunopereira.projetoaiko.service.exceptions.ResourceNotFoundException;

@Service
public class EquipmentPositionHistoryService {
	

	@Autowired
	private EquipmentPositionHistoryRepository repository;

	public List<EquipmentPositionHistory> findAll() {
		return repository.findAll();
	}
	
	public EquipmentPositionHistory findById(Long id) {
		return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	public EquipmentPositionHistory insert(EquipmentPositionHistory obj) {
		return repository.save(obj);
	}
	
	public EquipmentPositionHistory update(Long id, EquipmentPositionHistory obj) {

		return repository.findById(id).map(equipmentPositionHistory -> {
			equipmentPositionHistory.setId(obj.getId());
			equipmentPositionHistory.setLat(obj.getLat());
			equipmentPositionHistory.setDate(obj.getDate());
			equipmentPositionHistory.setEquipment(obj.getEquipment());
			return repository.save(equipmentPositionHistory);
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
