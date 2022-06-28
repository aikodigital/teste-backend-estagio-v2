package com.aikoequipment.equipment.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aikoequipment.equipment.dtos.EquipmentModelStateHourlyEarningsDTO;
import com.aikoequipment.equipment.entities.EquipmentModelStateHourlyEarnings;
import com.aikoequipment.equipment.entities.PK.EquipmentModelStateHourlyEarningsPK;
import com.aikoequipment.equipment.repositories.EquipmentModelStateHourlyEarningsRepository;
import com.aikoequipment.equipment.services.exception.DatabaseException;
import com.aikoequipment.equipment.services.exception.ResourceNotFoundException;

@Service
public class EquipmentModelStateHourlyEarningsService {
	
	@Autowired
	private EquipmentModelStateHourlyEarningsRepository repository;
	
	
	@Transactional(readOnly = true)
	public List<EquipmentModelStateHourlyEarnings> findAll() {
		return repository.findAll();
	}

	@Transactional(readOnly = true)
	public EquipmentModelStateHourlyEarningsDTO findById(EquipmentModelStateHourlyEarningsPK id) {
		Optional<EquipmentModelStateHourlyEarnings> obj = repository.findById(id);
		EquipmentModelStateHourlyEarnings entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entity not found"));
		return new EquipmentModelStateHourlyEarningsDTO(entity);
	}

	@Transactional
	public EquipmentModelStateHourlyEarningsDTO insert(EquipmentModelStateHourlyEarningsDTO dto) {
		EquipmentModelStateHourlyEarnings entity = new EquipmentModelStateHourlyEarnings();
		entity.setValue(dto.getValue());
		entity = repository.save(entity);
		return new EquipmentModelStateHourlyEarningsDTO(entity);
	}
	
	public EquipmentModelStateHourlyEarningsDTO update(EquipmentModelStateHourlyEarningsPK id,
			EquipmentModelStateHourlyEarningsDTO dto) {
		try {
			EquipmentModelStateHourlyEarnings entity = repository.getReferenceById(id);
			entity.setValue(dto.getValue());
			entity = repository.save(entity);
			return new EquipmentModelStateHourlyEarningsDTO(entity);
		}
		catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException("Id not found " + id);
		}		
	}


	public void delete(EquipmentModelStateHourlyEarningsPK id) {
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
