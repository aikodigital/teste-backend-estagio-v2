package com.pedroacbg.api.repository;

import com.pedroacbg.api.entities.EquipmentModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface EquipmentModelRepository extends JpaRepository<EquipmentModel, UUID> {
}
