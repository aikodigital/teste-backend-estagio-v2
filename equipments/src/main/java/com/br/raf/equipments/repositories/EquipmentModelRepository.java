package com.br.raf.equipments.repositories;

import com.br.raf.equipments.entities.EquipmentModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface EquipmentModelRepository extends JpaRepository<EquipmentModel, UUID> {
}
