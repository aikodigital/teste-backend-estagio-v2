package com.vitor.forestequipment.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.vitor.forestequipment.models.EquipmentState;
import com.vitor.forestequipment.repositories.EquipmentStateRepository;

@Service
public class EquipmentStateService {
	
	final EquipmentStateRepository equipmentStateRepository;
	
	public EquipmentStateService(EquipmentStateRepository equipmentStateRepository) {
		this.equipmentStateRepository = equipmentStateRepository;
	}

	@Transactional
	public EquipmentState save(EquipmentState equipmentState) {
		return equipmentStateRepository.save(equipmentState);
	}

	public List<EquipmentState> findAll() {
		return equipmentStateRepository.findAll();
	}

	public Optional<EquipmentState> findById(UUID id) {
		return equipmentStateRepository.findById(id);
	}

	@Transactional
	public void delete(EquipmentState equipmentState) {
		equipmentStateRepository.delete(equipmentState);
		
	}
}
