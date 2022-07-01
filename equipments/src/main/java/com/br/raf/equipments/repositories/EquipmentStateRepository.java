package com.br.raf.equipments.repositories;

import com.br.raf.equipments.entities.EquipmentState;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface EquipmentStateRepository extends JpaRepository<EquipmentState, UUID> {
}
