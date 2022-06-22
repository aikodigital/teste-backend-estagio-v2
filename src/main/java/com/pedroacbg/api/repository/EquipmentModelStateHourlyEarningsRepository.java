package com.pedroacbg.api.repository;

import com.pedroacbg.api.entities.EquipmentModel;
import com.pedroacbg.api.entities.EquipmentModelStateHourlyEarnings;
import com.pedroacbg.api.entities.EquipmentState;
import com.pedroacbg.api.pk.EquipmentModelStateHourlyEarningsPK;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface EquipmentModelStateHourlyEarningsRepository extends JpaRepository<EquipmentModelStateHourlyEarnings, EquipmentModelStateHourlyEarningsPK> {

}
