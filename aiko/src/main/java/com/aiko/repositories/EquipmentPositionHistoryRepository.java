package com.aiko.repositories;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.aiko.domain.EquipmentPositionHistory;

@Repository
public interface EquipmentPositionHistoryRepository extends JpaRepository<EquipmentPositionHistory, UUID> {

	@Query(value = "select distinct on (equipment_id) equipment_id, date, lat, lon, equipment_id as id "
			+ "from operation.equipment_position_history eph order by 1,2 desc", nativeQuery = true)
	public List<EquipmentPositionHistory> findPosition();
}
