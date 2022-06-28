package com.estagio.aiko.equipments.api.application.equipment.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.estagio.aiko.equipments.api.domain.equipment.exception.ResourceNotFoundException;
import com.estagio.aiko.equipments.api.domain.equipment.model.EquipmentModel;
import com.estagio.aiko.equipments.api.domain.equipment.service.EquipmentModelService;
import com.estagio.aiko.equipments.api.infrastructure.persistence.repository.equipment.EquipmentModelRepository;

@Service
public class EquipmentModelServiceImpl implements EquipmentModelService {

	private final EquipmentModelRepository equipmentModelRepository;
	
	public EquipmentModelServiceImpl(EquipmentModelRepository equipmentModelRepository) {
		this.equipmentModelRepository = equipmentModelRepository;
	}

	@Override
	public EquipmentModel create(EquipmentModel object) {
		return equipmentModelRepository.save(object);
	}

	@Override
	public List<EquipmentModel> findAll() {
		return equipmentModelRepository.findAll();
	}

	@Override
	
	public EquipmentModel findById(UUID id) {
		return equipmentModelRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException());
	}

	@Override
	public EquipmentModel update(UUID id, EquipmentModel object) {
		EquipmentModel savedEquipmentModel = equipmentModelRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException());
		BeanUtils.copyProperties(object, savedEquipmentModel, "id");
		
		return equipmentModelRepository.save(savedEquipmentModel);
	}

	@Override
	public void delete(UUID id) {
		EquipmentModel equipmentModel = equipmentModelRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException());
		equipmentModelRepository.delete(equipmentModel);
	}

}
