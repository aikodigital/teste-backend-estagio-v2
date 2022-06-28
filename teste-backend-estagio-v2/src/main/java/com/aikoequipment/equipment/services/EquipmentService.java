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

import com.aikoequipment.equipment.dtos.EquipmentDTO;
import com.aikoequipment.equipment.entities.Equipment;
import com.aikoequipment.equipment.repositories.EquipmentRepository;
import com.aikoequipment.equipment.services.exception.DatabaseException;
import com.aikoequipment.equipment.services.exception.ResourceNotFoundException;

@Service
public class EquipmentService {

	@Autowired
	private EquipmentRepository repository;

	@Transactional(readOnly = true)
	public List<Equipment> findAll() {
		return repository.findAll();
	}

	@Transactional(readOnly = true)
	public EquipmentDTO findById(UUID id) {
		Optional<Equipment> obj = repository.findById(id);
		Equipment entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entity not found"));
		return new EquipmentDTO(entity);
	}

	@Transactional
	public EquipmentDTO insert(EquipmentDTO dto) {
		Equipment entity = new Equipment();
		copyDtoToEntity(dto, entity);
		entity = repository.save(entity);
		return new EquipmentDTO(entity);
	}

	@Transactional
	public EquipmentDTO update(UUID id, EquipmentDTO dto) {
		try {
			Equipment entity = repository.getReferenceById(id);
			copyDtoToEntity(dto, entity);
			entity = repository.save(entity);
			return new EquipmentDTO(entity);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException("Id not found " + id);
		}
	}

	public void delete(UUID id) {
		try {
			repository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException("Id not found " + id);
		} catch (DataIntegrityViolationException e) {
			throw new DatabaseException("Integrity violation");
		}
	}

	private void copyDtoToEntity(EquipmentDTO dto, Equipment entity) {

		entity.setName(dto.getName());
		entity.setEquipmentModel(dto.getEquipmentModel());

	}

}
