package com.app.project.repositories;

import com.app.project.domain.EquipmentModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EquipModelRepository extends JpaRepository<EquipmentModel, Long> {
}
