package com.brunozarth.testeaiko.repository;

import com.brunozarth.testeaiko.model.EquipmentState;
import com.brunozarth.testeaiko.model.EquipmentStateHistory;
import com.brunozarth.testeaiko.model.EquipmentStateHistoryId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface EquipmentStateHistoryRepository extends JpaRepository<EquipmentStateHistory, EquipmentStateHistoryId> {
    List<EquipmentStateHistory> findByIdEquipmentId(UUID id);

    List<EquipmentStateHistory> findByIdEquipmentStateId(UUID id);
}
