package com.aikoequipment.equipment.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aikoequipment.equipment.dtos.EquipmentStateHistoryDTO;
import com.aikoequipment.equipment.entities.EquipmentStateHistory;
import com.aikoequipment.equipment.entities.PK.EquipmentStateHistoryPK;
import com.aikoequipment.equipment.repositories.EquipmentStateHistoryRepository;
import com.aikoequipment.equipment.services.exception.DatabaseException;
import com.aikoequipment.equipment.services.exception.ResourceNotFoundException;

@Service
public class EquipmentStateHistoryService {

	@Autowired
	private EquipmentStateHistoryRepository repository;
	
	@Transactional(readOnly = true)
	public List<EquipmentStateHistory> findAll() {
		return repository.findAll();
	}

	@Transactional(readOnly = true)
	public EquipmentStateHistoryDTO findById(EquipmentStateHistoryPK id) {
		Optional<EquipmentStateHistory> obj = repository.findById(id);
		EquipmentStateHistory entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entity not found"));
		return new EquipmentStateHistoryDTO(entity);
	}

	@Transactional
	public EquipmentStateHistoryDTO insert(EquipmentStateHistoryDTO dto) {
		EquipmentStateHistory entity = new EquipmentStateHistory();
		entity.setDate(dto.getDate());
		entity = repository.save(entity);
		return new EquipmentStateHistoryDTO(entity);
	}

	@Transactional
	public EquipmentStateHistoryDTO update(EquipmentStateHistoryPK id, EquipmentStateHistoryDTO dto) {
		try {
			EquipmentStateHistory entity = repository.getReferenceById(id);
			entity.setDate(dto.getDate());
			entity = repository.save(entity);
			return new EquipmentStateHistoryDTO(entity);
		}
		catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException("Id not found " + id);
		}		
	}

	public void delete(EquipmentStateHistoryPK id) {
		try {
			repository.deleteById(id);
		}
		catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException("Id not found " + id);
		}
		catch (DataIntegrityViolationException e) {
			throw new DatabaseException("Integrity violation");
		}
	}

	
}
