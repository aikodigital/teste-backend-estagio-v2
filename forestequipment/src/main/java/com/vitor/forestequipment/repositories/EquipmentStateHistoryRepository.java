package com.vitor.forestequipment.repositories;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.vitor.forestequipment.models.EquipmentStateHistory;
import com.vitor.forestequipment.models.EquipmentStateHistoryId;

public interface EquipmentStateHistoryRepository extends JpaRepository<EquipmentStateHistory, EquipmentStateHistoryId> {

	@Query(value = "FROM EquipmentStateHistory WHERE equipmentStateHistoryId.equipment.id = ?1")
	public List<EquipmentStateHistory> findByEquipmentStateHistoryIdEquipmentId(UUID id);
}
