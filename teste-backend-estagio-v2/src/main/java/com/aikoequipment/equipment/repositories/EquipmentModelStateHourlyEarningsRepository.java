package com.aikoequipment.equipment.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aikoequipment.equipment.entities.EquipmentModelStateHourlyEarnings;
import com.aikoequipment.equipment.entities.PK.EquipmentModelStateHourlyEarningsPK;


@Repository
public interface EquipmentModelStateHourlyEarningsRepository extends JpaRepository<EquipmentModelStateHourlyEarnings, EquipmentModelStateHourlyEarningsPK> {

}
