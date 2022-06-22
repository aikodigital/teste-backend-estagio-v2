package com.pedroacbg.api.repository;

import com.pedroacbg.api.entities.Equipment;
import com.pedroacbg.api.entities.EquipmentState;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface EquipmentStateRepository extends JpaRepository<EquipmentState, UUID> {
}
