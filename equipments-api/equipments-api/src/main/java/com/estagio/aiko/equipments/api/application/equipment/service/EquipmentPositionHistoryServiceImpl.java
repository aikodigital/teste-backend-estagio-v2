package com.estagio.aiko.equipments.api.application.equipment.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.estagio.aiko.equipments.api.domain.equipment.exception.ResourceNotFoundException;
import com.estagio.aiko.equipments.api.domain.equipment.model.Equipment;
import com.estagio.aiko.equipments.api.domain.equipment.model.EquipmentPositionHistory;
import com.estagio.aiko.equipments.api.domain.equipment.service.EquipmentPositionHistoryService;
import com.estagio.aiko.equipments.api.infrastructure.persistence.repository.equipment.EquipmentPositionHistoryRepository;
import com.estagio.aiko.equipments.api.infrastructure.persistence.repository.equipment.EquipmentRepository;

@Service
public class EquipmentPositionHistoryServiceImpl implements EquipmentPositionHistoryService {

	private final EquipmentPositionHistoryRepository equipmentPositionHistoryRepository;
	private final EquipmentRepository equipmentRepository;

	public EquipmentPositionHistoryServiceImpl(EquipmentPositionHistoryRepository equipmentPositionHistoryRepository,
			EquipmentRepository equipmentRepository) {
		this.equipmentPositionHistoryRepository = equipmentPositionHistoryRepository;
		this.equipmentRepository = equipmentRepository;
	}

	@Override
	public EquipmentPositionHistory create(EquipmentPositionHistory object) {
		Equipment equipment = equipmentRepository.findById(object.getEquipment().getId())
				.orElseThrow(() -> new ResourceNotFoundException("Equipment"));

		object.setEquipment(equipment);

		return equipmentPositionHistoryRepository.save(object);
	}

	@Override
	public EquipmentPositionHistory update(UUID id, EquipmentPositionHistory object) {
		EquipmentPositionHistory savedEquipmentPositionHistory = equipmentPositionHistoryRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException());
		Equipment equipment = equipmentRepository.findById(object.getEquipment().getId())
				.orElseThrow(() -> new ResourceNotFoundException("Equipment"));
		
		object.setEquipment(equipment);
		BeanUtils.copyProperties(object, savedEquipmentPositionHistory, "id");

		return equipmentPositionHistoryRepository.save(savedEquipmentPositionHistory);
	}

	@Override
	public List<EquipmentPositionHistory> findAll() {
		return equipmentPositionHistoryRepository.findAll();
	}

	@Override
	public EquipmentPositionHistory findById(UUID id) {
		return equipmentPositionHistoryRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException());
	}

	@Override
	public void delete(UUID id) {
		EquipmentPositionHistory equipmentPositionHistory = equipmentPositionHistoryRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException());
		equipmentPositionHistoryRepository.delete(equipmentPositionHistory);
	}

}
