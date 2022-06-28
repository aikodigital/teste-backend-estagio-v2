package com.vitor.forestequipment.repositories;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.vitor.forestequipment.models.EquipmentPositionHistory;
import com.vitor.forestequipment.models.EquipmentPositionHistoryId;

public interface EquipmentPositionHistoryRepository extends JpaRepository<EquipmentPositionHistory, EquipmentPositionHistoryId> {

	@Query(value = "FROM EquipmentPositionHistory WHERE equipmentPositionHistoryId.equipment.id = ?1")
	public List<EquipmentPositionHistory> findByEquipmentPositionHistoryIdEquipmentId(UUID id);

}
