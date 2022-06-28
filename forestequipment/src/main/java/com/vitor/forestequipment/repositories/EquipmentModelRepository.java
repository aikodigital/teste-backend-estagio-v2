package com.vitor.forestequipment.repositories;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vitor.forestequipment.models.EquipmentModel;

public interface EquipmentModelRepository extends JpaRepository<EquipmentModel, UUID> {

	Optional<EquipmentModel> findById(UUID id);

}
