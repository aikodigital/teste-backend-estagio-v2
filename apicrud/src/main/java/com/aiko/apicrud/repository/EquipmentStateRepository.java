package com.aiko.apicrud.repository;

/**
 *
 * @author Celso França Neto
 */

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import com.aiko.apicrud.models.EquipmentState;

public interface EquipmentStateRepository extends JpaRepository<EquipmentState, String> {
    EquipmentState findById(UUID id);
}
