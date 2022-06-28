package com.vitor.forestequipment.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.vitor.forestequipment.models.EquipmentStateHistory;
import com.vitor.forestequipment.models.EquipmentStateHistoryId;
import com.vitor.forestequipment.repositories.EquipmentStateHistoryRepository;

@Service
public class EquipmentStateHistoryService {

	final EquipmentStateHistoryRepository equipmentStateHistoryRepository;

	public EquipmentStateHistoryService(EquipmentStateHistoryRepository equipmentStateHistoryRepository) {
		this.equipmentStateHistoryRepository = equipmentStateHistoryRepository;
	}

	@Transactional
	public EquipmentStateHistory save(EquipmentStateHistory equipmentStateHistory) {
		return equipmentStateHistoryRepository.save(equipmentStateHistory);
	}

	public List<EquipmentStateHistory> getAllEquipmentStates(UUID id) {
		return equipmentStateHistoryRepository.findByEquipmentStateHistoryIdEquipmentId(id);
	}

	public Optional<EquipmentStateHistory> findById(EquipmentStateHistoryId id) {
		return equipmentStateHistoryRepository.findById(id);
	}

}
