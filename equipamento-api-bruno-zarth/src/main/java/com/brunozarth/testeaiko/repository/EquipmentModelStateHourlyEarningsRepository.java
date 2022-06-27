package com.brunozarth.testeaiko.repository;

import com.brunozarth.testeaiko.model.EquipmentModelStateHourlyEarnings;
import com.brunozarth.testeaiko.model.EquipmentModelStateHourlyEarningsId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;


@Repository
public interface EquipmentModelStateHourlyEarningsRepository extends JpaRepository<EquipmentModelStateHourlyEarnings, EquipmentModelStateHourlyEarningsId> {

    List<EquipmentModelStateHourlyEarnings> findByIdEquipmentModelId(UUID id);

    List<EquipmentModelStateHourlyEarnings> findByIdEquipmentStateId(UUID id);

}
