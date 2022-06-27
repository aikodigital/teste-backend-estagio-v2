package com.brunozarth.testeaiko.repository;

import com.brunozarth.testeaiko.model.Equipment;
import com.brunozarth.testeaiko.model.EquipmentPositionHistory;
import com.brunozarth.testeaiko.model.EquipmentPositionHistoryId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface EquipmentPositionHistoryRepository extends JpaRepository<EquipmentPositionHistory, EquipmentPositionHistoryId> {
    List<EquipmentPositionHistory> findByIdEquipmentId(UUID id);
}
