package com.aiko.testebackendestagiov2.repositories;

import java.util.UUID;

import com.aiko.testebackendestagiov2.models.Equipment;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EquipmentRepository extends JpaRepository<Equipment, UUID> {
    
}