package com.aiko.testebackendestagiov2.repositories;

import com.aiko.testebackendestagiov2.entities.Equipment;
import com.aiko.testebackendestagiov2.entities.EquipmentPositionHistory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface EquipmentPositionHistoryRepository extends JpaRepository<EquipmentPositionHistory, UUID> {
}
