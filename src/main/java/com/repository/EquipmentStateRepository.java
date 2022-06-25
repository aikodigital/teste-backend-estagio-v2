package com.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;


import com.model.EquipmentState ;

public interface EquipmentStateRepository extends JpaRepository<EquipmentState, UUID> {
	List<EquipmentState> findByName(String name);
	List<EquipmentState> findByColor(String color);

}
