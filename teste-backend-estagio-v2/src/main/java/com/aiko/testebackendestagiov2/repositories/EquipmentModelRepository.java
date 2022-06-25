package com.aiko.testebackendestagiov2.repositories;

import com.aiko.testebackendestagiov2.entities.EquipmentModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface EquipmentModelRepository extends JpaRepository<EquipmentModel, UUID> {
}
