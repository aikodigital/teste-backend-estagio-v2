package com.vitor.forestequipment.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.vitor.forestequipment.models.EquipmentPositionHistory;
import com.vitor.forestequipment.models.EquipmentPositionHistoryId;
import com.vitor.forestequipment.repositories.EquipmentPositionHistoryRepository;

@Service
public class EquipmentPositionHistoryService {

	final EquipmentPositionHistoryRepository equipmentPositionHistoryRepository;

	public EquipmentPositionHistoryService(EquipmentPositionHistoryRepository equipmentPositionHistoryRepository) {
		this.equipmentPositionHistoryRepository = equipmentPositionHistoryRepository;
	}

	@Transactional
	public EquipmentPositionHistory save(EquipmentPositionHistory equipmentPositionHistory) {
		return equipmentPositionHistoryRepository.save(equipmentPositionHistory);
	}

	public List<EquipmentPositionHistory> getAllEquipmentPositions(UUID id) {
		return equipmentPositionHistoryRepository.findByEquipmentPositionHistoryIdEquipmentId(id);
	}

	public Optional<EquipmentPositionHistory> findById(EquipmentPositionHistoryId id) {
		return equipmentPositionHistoryRepository.findById(id);
	}


}
