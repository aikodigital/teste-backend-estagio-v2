package com.equipments.apirest.repositories;

import com.equipments.apirest.models.EquipmentStateHistory;
import com.equipments.apirest.models.EquipmentStateHistoryId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EquipmentStateHistoryRepository extends JpaRepository<EquipmentStateHistory, EquipmentStateHistoryId> {

}
