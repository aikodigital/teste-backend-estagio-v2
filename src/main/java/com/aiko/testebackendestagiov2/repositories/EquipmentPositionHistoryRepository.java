package com.aiko.testebackendestagiov2.repositories;

import java.util.List;
import java.util.UUID;

import com.aiko.testebackendestagiov2.models.EquipmentPositionHistory;
import com.aiko.testebackendestagiov2.models.pk.EquipmentPositionHistoryPK;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface EquipmentPositionHistoryRepository extends JpaRepository<EquipmentPositionHistory, EquipmentPositionHistoryPK> {
   
    @Query(value = "SELECT h FROM EquipmentPositionHistory AS h JOIN h.id AS pk JOIN pk.equipment AS e WHERE e.id = ?1")
    List<EquipmentPositionHistory> findEquipmentPositionHistory(UUID equipmentId);

    @Query(value = "SELECT h FROM EquipmentPositionHistory AS h JOIN h.id AS pk JOIN pk.equipment AS e WHERE e.id = ?1 ORDER BY pk.date DESC")
    List<EquipmentPositionHistory> findCurrentEquipmentPosition(UUID equipmentId);

}