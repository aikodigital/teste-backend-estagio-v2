package com.aiko.testebackendestagiov2.repositories;

import com.aiko.testebackendestagiov2.models.EquipmentModelStateHourlyEarnings;
import com.aiko.testebackendestagiov2.models.pk.EquipmentModelStateHourlyEarningsPK;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EquipmentModelStateHourlyEarningsRepository extends JpaRepository<EquipmentModelStateHourlyEarnings, EquipmentModelStateHourlyEarningsPK> {
    
}