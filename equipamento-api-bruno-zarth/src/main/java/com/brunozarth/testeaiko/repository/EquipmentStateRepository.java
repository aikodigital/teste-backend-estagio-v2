package com.brunozarth.testeaiko.repository;

import com.brunozarth.testeaiko.model.EquipmentState;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface EquipmentStateRepository extends JpaRepository<EquipmentState, UUID> {
    List<EquipmentState> findByName(String name);
}
