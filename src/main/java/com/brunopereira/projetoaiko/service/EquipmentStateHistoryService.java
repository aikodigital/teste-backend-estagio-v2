package com.brunopereira.projetoaiko.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.brunopereira.projetoaiko.entities.EquipmentStateHistory;
import com.brunopereira.projetoaiko.repositores.EquipmentStateHistoryRepository;
import com.brunopereira.projetoaiko.service.exceptions.DatabaseException;
import com.brunopereira.projetoaiko.service.exceptions.ResourceNotFoundException;

@Service
public class EquipmentStateHistoryService {

	@Autowired
	private EquipmentStateHistoryRepository repository;

	public List<EquipmentStateHistory> findAll() {
		return repository.findAll();
	}

	public EquipmentStateHistory findById(Long id) {

		return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
	}

	public EquipmentStateHistory insert(EquipmentStateHistory obj) {
		return repository.save(obj);
	}

	public EquipmentStateHistory update(Long id, EquipmentStateHistory obj) {

		return repository.findById(id).map(equipmentStateHistory -> {
			equipmentStateHistory.setId(obj.getId());
			equipmentStateHistory.setEquipment(obj.getEquipment());
			equipmentStateHistory.setDate(obj.getDate());
			equipmentStateHistory.setEquipmentState(obj.getEquipmentState());

			return repository.save(equipmentStateHistory);

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
