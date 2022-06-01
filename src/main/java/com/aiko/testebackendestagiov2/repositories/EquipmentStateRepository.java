package com.aiko.testebackendestagiov2.repositories;

import java.util.UUID;

import com.aiko.testebackendestagiov2.models.EquipmentState;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EquipmentStateRepository extends JpaRepository<EquipmentState, UUID> {
    
}