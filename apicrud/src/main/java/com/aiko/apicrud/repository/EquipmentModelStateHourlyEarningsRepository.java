package com.aiko.apicrud.repository;

/**
 *
 * @author Celso França Neto
 */

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aiko.apicrud.models.EquipmentModelStateHourlyEarnings;

public interface EquipmentModelStateHourlyEarningsRepository
        extends JpaRepository<EquipmentModelStateHourlyEarnings, String> {
    EquipmentModelStateHourlyEarningsRepository deleteByEquipmentModel(UUID id);
}
