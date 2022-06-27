package com.brunozarth.testeaiko.repository;

import com.brunozarth.testeaiko.model.EquipmentModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface EquipmentModelRepository extends JpaRepository<EquipmentModel, UUID> {
    public List<EquipmentModel> findByName(String name);
}
