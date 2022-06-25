package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.model.EquipmentPositionHistory;
import com.model.PositionHistoryId;

public interface EquipmentPositionHistoryRepository extends JpaRepository<EquipmentPositionHistory,PositionHistoryId >{
	
	
	
}
