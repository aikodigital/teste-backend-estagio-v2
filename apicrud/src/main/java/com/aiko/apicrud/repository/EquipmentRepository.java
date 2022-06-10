package com.aiko.apicrud.repository;

/**
 *
 * @author Celso França Neto
 */

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import com.aiko.apicrud.models.Equipment;

public interface EquipmentRepository extends JpaRepository<Equipment, String> {
    Equipment findById(UUID id);
}
