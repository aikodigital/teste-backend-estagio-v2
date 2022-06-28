package com.equipments.apirest.repositories;

import com.equipments.apirest.models.EquipmentModelStateHourlyEarnings;
import com.equipments.apirest.models.EquipmentModelStateHourlyEarningsId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface EquipmentModelStateHourlyEarningsRepository extends JpaRepository<EquipmentModelStateHourlyEarnings, EquipmentModelStateHourlyEarningsId> {

    @Query("FROM EquipmentModelStateHourlyEarnings h WHERE h.id.equipmentModel.id = :modelId AND h.id.equipmentState.id = :stateId")
    List<EquipmentModelStateHourlyEarnings> findAll(UUID modelId, UUID stateId);
}
