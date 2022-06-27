package com.aiko.testebackendestagiov2.repositories;

import com.aiko.testebackendestagiov2.entities.EquipmentStateHistory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface EquipmentStateHistoryRepository extends JpaRepository<EquipmentStateHistory, UUID> {
}
