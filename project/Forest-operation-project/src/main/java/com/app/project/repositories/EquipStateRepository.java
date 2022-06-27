package com.app.project.repositories;

import com.app.project.domain.EquipmentState;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EquipStateRepository extends JpaRepository<EquipmentState, Long> {
}
