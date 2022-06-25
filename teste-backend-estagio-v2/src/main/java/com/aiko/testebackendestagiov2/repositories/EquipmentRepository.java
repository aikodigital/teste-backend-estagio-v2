package com.aiko.testebackendestagiov2.repositories;

import com.aiko.testebackendestagiov2.entities.Equipment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface EquipmentRepository extends JpaRepository<Equipment, UUID> {
}
