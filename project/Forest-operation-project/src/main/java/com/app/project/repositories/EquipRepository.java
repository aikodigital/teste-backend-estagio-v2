package com.app.project.repositories;

import com.app.project.domain.Equipment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface EquipRepository extends JpaRepository<Equipment, UUID> {
}
