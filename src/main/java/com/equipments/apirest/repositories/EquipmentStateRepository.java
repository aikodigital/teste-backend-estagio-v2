package com.equipments.apirest.repositories;

import com.equipments.apirest.models.EquipmentState;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface EquipmentStateRepository extends JpaRepository<EquipmentState, UUID> {
}
