package com.equipments.apirest.repositories;

import com.equipments.apirest.models.EquipmentModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;


public interface EquipmentModelRepository extends JpaRepository<EquipmentModel, UUID> {
}
