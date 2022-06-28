package com.aikoequipment.equipment.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aikoequipment.equipment.entities.EquipmentPositionHistory;
import com.aikoequipment.equipment.entities.PK.EquipmentPositionHistoryPK;

@Repository
public interface EquipmentPositionHistoryRepository extends JpaRepository<EquipmentPositionHistory, EquipmentPositionHistoryPK> {

}
