package com.pedroacbg.api.repository;

import com.pedroacbg.api.entities.Equipment;
import com.pedroacbg.api.entities.EquipmentPositionHistory;
import com.pedroacbg.api.pk.EquipmentPositionHistoryPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface EquipmentPositionHistoryRepository extends JpaRepository<EquipmentPositionHistory, EquipmentPositionHistoryPK> {
    @Query(value = "SELECT x FROM EquipmentPositionHistory AS x JOIN x.id AS pk JOIN pk.equipment AS y WHERE y.id = ?1")
    List<EquipmentPositionHistory> findEquipmentPositionHistoryById(UUID equipmentId);

    @Query(value = "SELECT x FROM EquipmentPositionHistory AS x JOIN x.id AS pk JOIN pk.equipment AS y WHERE y.id = ?1 ORDER BY pk.date DESC")
    List<EquipmentPositionHistory> findCurrentEquipmentPosition(UUID equipmentId);

}
