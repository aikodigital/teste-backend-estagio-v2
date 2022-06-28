package com.app.project.repositories;

import com.app.project.domain.EquipmentStateHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface EquipStateHistoryRepository extends JpaRepository<EquipmentStateHistory, UUID> {
}
