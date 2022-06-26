package com.aiko.testebackendestagiov2.repositories;

import com.aiko.testebackendestagiov2.entities.EquipmentModelStateHourlyEarnings;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface EquipmentModelStateHourlyEarningsRepository extends
        JpaRepository<EquipmentModelStateHourlyEarnings, UUID> {
}
