package com.brunozarth.testeaiko.repository;

import com.brunozarth.testeaiko.model.Equipment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface EquipmentRepository extends JpaRepository<Equipment, UUID> {
    public List<Equipment> findByName(String name);
}
