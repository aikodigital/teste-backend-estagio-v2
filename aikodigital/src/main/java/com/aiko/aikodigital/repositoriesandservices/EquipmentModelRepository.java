package com.aiko.aikodigital.repositoriesandservices;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aiko.aikodigital.enties.Equipment_model;

public interface EquipmentModelRepository extends JpaRepository<Equipment_model, UUID>{

}
