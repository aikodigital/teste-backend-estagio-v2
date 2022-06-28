package com.vitor.forestequipment.repositories;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vitor.forestequipment.models.EquipmentState;

public interface EquipmentStateRepository extends JpaRepository<EquipmentState, UUID> {

	Optional<EquipmentState> findById(UUID id);
}
