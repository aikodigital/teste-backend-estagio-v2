package com.pedroacbg.api.repository;

import com.pedroacbg.api.entities.Equipment;
import com.pedroacbg.api.entities.EquipmentStateHistory;
import com.pedroacbg.api.pk.EquipmentStateHistoryPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface EquipmentStateHistoryRepository extends JpaRepository<EquipmentStateHistory, EquipmentStateHistoryPK> {

    @Query(value = "SELECT h FROM EquipmentStateHistory AS h JOIN h.id AS pk JOIN pk.equipment AS e WHERE e.id = ?1")
    List<EquipmentStateHistory> findEquipmentStateHistory(UUID equipmentId);

    @Query(value = "SELECT h FROM EquipmentStateHistory AS h JOIN h.id AS pk JOIN pk.equipment AS e WHERE e.id = ?1 ORDER BY pk.date DESC")
    List<EquipmentStateHistory> findCurrentState(UUID equipmentId);
}
