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

import com.aikoequipment.equipment.dtos.EquipmentModelDTO;
import com.aikoequipment.equipment.entities.EquipmentModel;
import com.aikoequipment.equipment.repositories.EquipmentModelRepository;
import com.aikoequipment.equipment.services.exception.DatabaseException;
import com.aikoequipment.equipment.services.exception.ResourceNotFoundException;

@Service
public class EquipmentModelService {
	
	@Autowired
	private EquipmentModelRepository repository;
	
	@Transactional(readOnly = true)
	public List<EquipmentModel> findAll() {
		return repository.findAll();
	}

	@Transactional(readOnly = true)
	public EquipmentModelDTO findById(UUID id) {
		Optional<EquipmentModel> obj = repository.findById(id);
		EquipmentModel entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entity not found"));
		return new EquipmentModelDTO(entity);
	}

	@Transactional
	public EquipmentModelDTO insert(EquipmentModelDTO dto) {
		EquipmentModel entity = new EquipmentModel();
		entity.setName(dto.getName());
		entity = repository.save(entity);
		return new EquipmentModelDTO(entity);
	}

	@Transactional
	public EquipmentModelDTO update(UUID id, EquipmentModelDTO dto) {
		try {
			EquipmentModel entity = repository.getReferenceById(id);
			entity.setName(dto.getName());
			entity = repository.save(entity);
			return new EquipmentModelDTO(entity);
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
