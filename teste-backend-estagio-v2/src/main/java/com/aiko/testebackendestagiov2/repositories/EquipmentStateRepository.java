package com.aiko.testebackendestagiov2.repositories;

import com.aiko.testebackendestagiov2.entities.EquipmentState;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface EquipmentStateRepository extends JpaRepository<EquipmentState, UUID> {
}
