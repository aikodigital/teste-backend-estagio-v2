package com.br.raf.equipments.repositories;

import com.br.raf.equipments.entities.EquipmentHistoryId;
import com.br.raf.equipments.entities.EquipmentPositionHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Repository
public interface EquipmentPositionHistoryRepository extends JpaRepository<EquipmentPositionHistory, EquipmentHistoryId> {
    public EquipmentPositionHistory findByDate(LocalDateTime dateTime);

    @Query(
            value = "select * from operation.equipment_position_history e WHERE e.equipment_id = ?1",
            nativeQuery = true
    )
    List<EquipmentPositionHistory> findByEquipmentId(UUID id);

}
