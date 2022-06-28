package com.estagio.aiko.equipments.api.application.equipment.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.estagio.aiko.equipments.api.domain.equipment.exception.ResourceNotFoundException;
import com.estagio.aiko.equipments.api.domain.equipment.model.Equipment;
import com.estagio.aiko.equipments.api.domain.equipment.model.EquipmentModel;
import com.estagio.aiko.equipments.api.domain.equipment.service.EquipmentService;
import com.estagio.aiko.equipments.api.infrastructure.persistence.repository.equipment.EquipmentModelRepository;
import com.estagio.aiko.equipments.api.infrastructure.persistence.repository.equipment.EquipmentRepository;

@Service
public class EquipmentServiceImpl implements EquipmentService {
	
	private final EquipmentRepository equipmentRepository;
	private final EquipmentModelRepository equipmentModelRepository;

	public EquipmentServiceImpl(
			EquipmentRepository equipmentRepository,
			EquipmentModelRepository equipmentModelRepository) {
		this.equipmentRepository = equipmentRepository;
		this.equipmentModelRepository = equipmentModelRepository;
	}

	@Override
	public Equipment create(Equipment object) {
		EquipmentModel model = equipmentModelRepository.findById(object.getModel().getId())
				.orElseThrow(() -> new ResourceNotFoundException("Equipment model"));
		
		object.setModel(model);

		return equipmentRepository.save(object);
	}

	@Override
	public Equipment update(UUID id, Equipment object) {
		Equipment savedEquipment = equipmentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException());
		EquipmentModel model = equipmentModelRepository.findById(object.getModel().getId())
				.orElseThrow(() -> new ResourceNotFoundException("Equipment model"));

		BeanUtils.copyProperties(object, savedEquipment, "id");
		savedEquipment.setModel(model);

		return equipmentRepository.save(savedEquipment);
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
	public void delete(UUID id) {
		Equipment equipment = equipmentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException());
		equipmentRepository.delete(equipment);
	}

}
