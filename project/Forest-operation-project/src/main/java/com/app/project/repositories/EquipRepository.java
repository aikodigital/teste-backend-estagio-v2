package com.app.project.repositories;

import com.app.project.domain.Equipment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface EquipRepository extends JpaRepository<Equipment, UUID> {
}
