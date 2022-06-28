package com.aikoequipment.equipment.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aikoequipment.equipment.entities.EquipmentStateHistory;
import com.aikoequipment.equipment.entities.PK.EquipmentStateHistoryPK;

@Repository
public interface EquipmentStateHistoryRepository extends JpaRepository<EquipmentStateHistory, EquipmentStateHistoryPK> {

}
