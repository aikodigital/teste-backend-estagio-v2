package com.aiko.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aiko.domain.EquipmentState;

@Repository
public interface EquipmentStateRepository extends JpaRepository<EquipmentState, UUID> {

}
