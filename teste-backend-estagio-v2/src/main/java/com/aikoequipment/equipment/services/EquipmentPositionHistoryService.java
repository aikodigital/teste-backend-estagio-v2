package com.aikoequipment.equipment.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aikoequipment.equipment.dtos.EquipmentPositionHistoryDTO;
import com.aikoequipment.equipment.entities.EquipmentPositionHistory;
import com.aikoequipment.equipment.entities.PK.EquipmentPositionHistoryPK;
import com.aikoequipment.equipment.repositories.EquipmentPositionHistoryRepository;
import com.aikoequipment.equipment.services.exception.DatabaseException;
import com.aikoequipment.equipment.services.exception.ResourceNotFoundException;

@Service
public class EquipmentPositionHistoryService {

	@Autowired
	private EquipmentPositionHistoryRepository repository;
	
	@Transactional(readOnly = true)
	public List<EquipmentPositionHistory> findAll() {
		return repository.findAll();
	}


	@Transactional(readOnly = true)
	public EquipmentPositionHistoryDTO findById(EquipmentPositionHistoryPK id) {
		Optional<EquipmentPositionHistory> obj = repository.findById(id);
		EquipmentPositionHistory entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entity not found"));
		return new EquipmentPositionHistoryDTO(entity);
	}

	@Transactional
	public EquipmentPositionHistoryDTO insert(EquipmentPositionHistoryDTO dto) {
		EquipmentPositionHistory entity = new EquipmentPositionHistory();
		entity.setDate(dto.getDate());
		entity.setLon(dto.getLon());
		entity.setLat(dto.getLat());
		entity = repository.save(entity);
		return new EquipmentPositionHistoryDTO(entity);
	}

	@Transactional
	public EquipmentPositionHistoryDTO update(EquipmentPositionHistoryPK id, EquipmentPositionHistoryDTO dto) {
		try {
			EquipmentPositionHistory entity = repository.getReferenceById(id);
			entity.setDate(dto.getDate());
			entity.setLon(dto.getLon());
			entity.setLat(dto.getLat());
			entity = repository.save(entity);
			return new EquipmentPositionHistoryDTO(entity);
		}
		catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException("Id not found " + id);
		}		
	}

	public void delete(EquipmentPositionHistoryPK id) {
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
