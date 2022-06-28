package com.vitor.forestequipment.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.vitor.forestequipment.models.EquipmentModel;
import com.vitor.forestequipment.repositories.EquipmentModelRepository;

@Service
public class EquipmentModelService {

	final EquipmentModelRepository equipmentModelRepository;
	
	public EquipmentModelService(EquipmentModelRepository equipmentModelRepository) {
		this.equipmentModelRepository = equipmentModelRepository;
	}

	@Transactional
	public EquipmentModel save(EquipmentModel equipmentModel) {
		return equipmentModelRepository.save(equipmentModel);
	}

	public List<EquipmentModel> findAll() {
		return equipmentModelRepository.findAll();
	}

	public Optional<EquipmentModel> findById(UUID id) {
		return equipmentModelRepository.findById(id);
	}

	@Transactional
	public void delete(EquipmentModel equipmentModel) {
		equipmentModelRepository.delete(equipmentModel);
		
	}
}
