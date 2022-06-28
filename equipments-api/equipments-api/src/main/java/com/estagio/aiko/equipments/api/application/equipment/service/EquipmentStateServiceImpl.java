package com.estagio.aiko.equipments.api.application.equipment.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.estagio.aiko.equipments.api.domain.equipment.exception.ResourceNotFoundException;
import com.estagio.aiko.equipments.api.domain.equipment.model.EquipmentState;
import com.estagio.aiko.equipments.api.domain.equipment.service.EquipmentStateService;
import com.estagio.aiko.equipments.api.infrastructure.persistence.repository.equipment.EquipmentStateRepository;

@Service
public class EquipmentStateServiceImpl implements EquipmentStateService {

	private final EquipmentStateRepository equipmentStateRepository;

	public EquipmentStateServiceImpl(EquipmentStateRepository equipmentStateRepository) {
		this.equipmentStateRepository = equipmentStateRepository;
	}

	@Override
	public EquipmentState create(EquipmentState object) {
		return equipmentStateRepository.save(object);
	}

	@Override
	public EquipmentState update(UUID id, EquipmentState object) {
		EquipmentState savedEquipmentState = equipmentStateRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException());
		BeanUtils.copyProperties(object, savedEquipmentState, "id");

		return equipmentStateRepository.save(savedEquipmentState);
	}

	@Override
	public List<EquipmentState> findAll() {
		return equipmentStateRepository.findAll();
	}

	@Override
	public EquipmentState findById(UUID id) {
		return equipmentStateRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException());
	}

	@Override
	public void delete(UUID id) {
		EquipmentState equipmentState = equipmentStateRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException());
		equipmentStateRepository.delete(equipmentState);
	}

}
