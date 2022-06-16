package com.aiko.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aiko.domain.Equipment;

@Repository
public interface EquipmentRepository extends JpaRepository<Equipment, UUID> {

}
