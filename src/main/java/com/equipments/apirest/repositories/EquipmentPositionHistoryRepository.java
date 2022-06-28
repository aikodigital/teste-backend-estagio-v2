package com.equipments.apirest.repositories;

import com.equipments.apirest.models.EquipmentPositionHistory;
import com.equipments.apirest.models.EquipmentPositionHistoryId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface EquipmentPositionHistoryRepository extends JpaRepository<EquipmentPositionHistory, EquipmentPositionHistoryId> {

    @Query("FROM EquipmentPositionHistory eph WHERE eph.equipmentPositionHistoryId.equipment.id = :equipmentId")
    List<EquipmentPositionHistory> findAll(UUID equipmentId);
}
