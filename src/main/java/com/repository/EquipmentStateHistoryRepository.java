package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.model.EquipmentStateHistory;
import com.model.StateHistoryId;

public interface EquipmentStateHistoryRepository extends JpaRepository<EquipmentStateHistory, StateHistoryId> {
	

}
