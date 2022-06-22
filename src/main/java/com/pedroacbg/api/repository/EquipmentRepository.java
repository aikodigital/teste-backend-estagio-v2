package com.pedroacbg.api.repository;

import com.pedroacbg.api.entities.Equipment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface EquipmentRepository extends JpaRepository<Equipment, UUID> {
}
