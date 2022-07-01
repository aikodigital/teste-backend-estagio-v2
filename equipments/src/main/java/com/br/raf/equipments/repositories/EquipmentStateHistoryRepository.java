package com.br.raf.equipments.repositories;

import com.br.raf.equipments.entities.EquipmentStateHistory;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public interface EquipmentStateHistoryRepository extends JpaRepository<EquipmentStateHistory, UUID> {
    public EquipmentStateHistory findByEquipmentId(UUID equipmentId);
    public EquipmentStateHistory findByEquipmentStateId(UUID equipmentStateId);

    public EquipmentStateHistory findByDate(LocalDateTime dateTime);
    /*@Query(
            value = "SELECT * FROM equipment_state_history e ORDER BY date Desc",
            nativeQuery = true
    )*/
    List<EquipmentStateHistory> findAll(Sort sort);



}
