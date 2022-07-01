package com.br.raf.equipments.repositories;

import com.br.raf.equipments.entities.EquipmentModelStateHourlyEarnings;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface EquipmentModelStateHourlyEarningsRepository extends JpaRepository<EquipmentModelStateHourlyEarnings, UUID> {
    public EquipmentModelStateHourlyEarnings findByValue(Integer value);
    public EquipmentModelStateHourlyEarnings deleteByValue(Integer value);
}
