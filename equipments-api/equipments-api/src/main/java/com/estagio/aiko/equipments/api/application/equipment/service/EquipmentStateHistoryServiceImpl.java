package com.estagio.aiko.equipments.api.application.equipment.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.estagio.aiko.equipments.api.domain.equipment.exception.ResourceNotFoundException;
import com.estagio.aiko.equipments.api.domain.equipment.model.Equipment;
import com.estagio.aiko.equipments.api.domain.equipment.model.EquipmentState;
import com.estagio.aiko.equipments.api.domain.equipment.model.EquipmentStateHistory;
import com.estagio.aiko.equipments.api.domain.equipment.service.EquipmentStateHistoryService;
import com.estagio.aiko.equipments.api.infrastructure.persistence.repository.equipment.EquipmentRepository;
import com.estagio.aiko.equipments.api.infrastructure.persistence.repository.equipment.EquipmentStateHistoryRepository;
import com.estagio.aiko.equipments.api.infrastructure.persistence.repository.equipment.EquipmentStateRepository;

@Service
public class EquipmentStateHistoryServiceImpl implements EquipmentStateHistoryService {

	private final EquipmentStateHistoryRepository equipmentStateHistoryRepository;
	private final EquipmentStateRepository equipmentStateRepository;
	private final EquipmentRepository equipmentRepository;

	public EquipmentStateHistoryServiceImpl(EquipmentStateHistoryRepository equipmentStateHistoryRepository,
			EquipmentStateRepository equipmentStateRepository, EquipmentRepository equipmentRepository) {
		this.equipmentStateHistoryRepository = equipmentStateHistoryRepository;
		this.equipmentStateRepository = equipmentStateRepository;
		this.equipmentRepository = equipmentRepository;
	}

	@Override
	public EquipmentStateHistory create(EquipmentStateHistory object) {
		Equipment equipment = equipmentRepository.findById(object.getEquipment().getId())
				.orElseThrow(() -> new ResourceNotFoundException("Equipment"));
		EquipmentState state = equipmentStateRepository.findById(object.getState().getId())
				.orElseThrow(() -> new ResourceNotFoundException("Equipment state"));

		object.setEquipment(equipment);
		object.setState(state);

		return equipmentStateHistoryRepository.save(object);
	}

	@Override
	public EquipmentStateHistory update(UUID id, EquipmentStateHistory object) {
		EquipmentStateHistory savedEquipmentStateHistory = equipmentStateHistoryRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException());
		Equipment equipment = equipmentRepository.findById(object.getEquipment().getId())
				.orElseThrow(() -> new ResourceNotFoundException("Equipment"));
		EquipmentState state = equipmentStateRepository.findById(object.getState().getId())
				.orElseThrow(() -> new ResourceNotFoundException("Equipment state"));

		object.setEquipment(equipment);
		object.setState(state);
		BeanUtils.copyProperties(object, savedEquipmentStateHistory, "id");

		return equipmentStateHistoryRepository.save(savedEquipmentStateHistory);
	}

	@Override
	public List<EquipmentStateHistory> findAll() {
		return equipmentStateHistoryRepository.findAll();
	}

	@Override
	public EquipmentStateHistory findById(UUID id) {
		return equipmentStateHistoryRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException());
	}

	@Override
	public void delete(UUID id) {
		EquipmentStateHistory equipmentStateHistory = equipmentStateHistoryRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException());
		equipmentStateHistoryRepository.delete(equipmentStateHistory);
	}

}
