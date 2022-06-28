package com.vitor.forestequipment.repositories;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vitor.forestequipment.models.Equipment;

public interface EquipmentRepository extends JpaRepository<Equipment, UUID> {

	Optional<Equipment> findById(UUID id);

}
