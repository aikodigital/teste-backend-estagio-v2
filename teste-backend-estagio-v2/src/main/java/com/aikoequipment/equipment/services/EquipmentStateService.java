package com.aikoequipment.equipment.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aikoequipment.equipment.dtos.EquipmentStateDTO;
import com.aikoequipment.equipment.entities.EquipmentState;
import com.aikoequipment.equipment.repositories.EquipmentStateRepository;
import com.aikoequipment.equipment.services.exception.DatabaseException;
import com.aikoequipment.equipment.services.exception.ResourceNotFoundException;

@Service
public class EquipmentStateService {
	
	@Autowired
	private EquipmentStateRepository repository;
	
	@Transactional(readOnly = true)
	public List<EquipmentState> findAll() {
		return repository.findAll();
	}

	@Transactional(readOnly = true)
	public EquipmentStateDTO findById(UUID id) {
		Optional<EquipmentState> obj = repository.findById(id);
		EquipmentState entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entity not found"));
		return new EquipmentStateDTO(entity);
	}

	@Transactional
	public EquipmentStateDTO insert(EquipmentStateDTO dto) {
		EquipmentState entity = new EquipmentState();
		entity.setName(dto.getName());
		entity = repository.save(entity);
		return new EquipmentStateDTO(entity);
	}

	@Transactional
	public EquipmentStateDTO update(UUID id, EquipmentStateDTO dto) {
		try {
			EquipmentState entity = repository.getReferenceById(id);
			entity.setName(dto.getName());
			entity = repository.save(entity);
			return new EquipmentStateDTO(entity);
		}
		catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException("Id not found " + id);
		}		
	}

	public void delete(UUID id) {
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
