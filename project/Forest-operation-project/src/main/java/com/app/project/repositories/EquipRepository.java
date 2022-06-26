package com.app.project.repositories;

import com.app.project.domain.Equipment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EquipRepository extends JpaRepository<Equipment, Long> {
}
