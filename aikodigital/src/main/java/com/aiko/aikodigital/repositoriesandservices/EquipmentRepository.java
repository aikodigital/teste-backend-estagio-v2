package com.aiko.aikodigital.repositoriesandservices;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aiko.aikodigital.enties.Equipment;

public interface EquipmentRepository extends JpaRepository<Equipment, UUID>{

}

