package com.aiko.apicrud.repository;

/**
 *
 * @author Celso França Neto
 */

import org.springframework.data.jpa.repository.JpaRepository;

import com.aiko.apicrud.models.EquipmentPositionHistory;

public interface EquipmentPositionHistoryRepository extends JpaRepository<EquipmentPositionHistory, String> {
}
