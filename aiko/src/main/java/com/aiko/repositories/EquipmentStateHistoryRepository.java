package com.aiko.repositories;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.aiko.domain.EquipmentStateHistory;

@Repository
public interface EquipmentStateHistoryRepository extends JpaRepository<EquipmentStateHistory, UUID> {

	@Query(value = "select distinct on (esh.equipment_id) esh.equipment_id as id, esh.equipment_id, esh.date,  es.id as equipment_state_id  from operation.equipment_state es "
			+ "inner join operation.equipment_state_history esh on (es.id = esh.equipment_state_id) "
			+ "order by 1, esh.date desc", nativeQuery = true)
	public List<EquipmentStateHistory> findAllState();
}
