package com.aiko.apicrud.repository;

/**
 *
 * @author Celso França Neto
 */

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aiko.apicrud.models.EquipmentModel;

public interface EquipmentModelRepository extends JpaRepository<EquipmentModel, String> {
    EquipmentModel findById(UUID id);
}
