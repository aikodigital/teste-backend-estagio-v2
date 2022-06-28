package com.estagio.aiko.equipments.api.application.equipment.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.estagio.aiko.equipments.api.domain.equipment.exception.ResourceNotFoundException;
import com.estagio.aiko.equipments.api.domain.equipment.model.Equipment;
import com.estagio.aiko.equipments.api.domain.equipment.model.EquipmentModel;
import com.estagio.aiko.equipments.api.domain.equipment.service.EquipmentPositionHistoryService;
import com.estagio.aiko.equipments.api.infrastructure.persistence.repository.equipment.EquipmentModelRepository;

@RestController
@RequestMapping("/equipment-position-history")
public class EquipmentPositionHistoryController {

	private final EquipmentPositionHistoryService equipmentPositionHistoryService;
	private final EquipmentModelRepository equipmentModelRepository;

	public EquipmentPositionHistoryController(
			EquipmentPositionHistoryService equipmentPositionHistoryService,
			EquipmentModelRepository equipmentModelRepository) {
		this.equipmentPositionHistoryService = equipmentPositionHistoryService;
		this.equipmentModelRepository = equipmentModelRepository;
	}
	
	@Override
	public Equipment create(Equipment object) {
		EquipmentModel model = equipmentModelRepository.findById(object.getModel().getId()).orElseThrow(() -> new ResourceNotFoundException());
		object.setModel(model);
		
		return equipmentRepository.save(object);
	}

	@Override
	public List<Equipment> findAll() {
		return equipmentRepository.findAll();
	}

	@Override
	public Equipment findById(UUID id) {
		return equipmentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException());
	}

	@Override
	public Equipment update(UUID id, Equipment object) {
		Equipment savedEquipment = equipmentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException());
		EquipmentModel model = equipmentModelRepository.findById(object.getModel().getId()).orElseThrow(() -> new ResourceNotFoundException());

		BeanUtils.copyProperties(object, savedEquipment, "id");
		savedEquipment.setModel(model);
		
		return equipmentRepository.save(savedEquipment);
	}

	@Override
	public void delete(UUID id) {
		Equipment equipment = equipmentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException());
		equipmentRepository.delete(equipment);
	}
	
}
