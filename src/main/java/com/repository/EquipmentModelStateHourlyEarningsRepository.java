package com.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;
import java.util.UUID;

import com.model.ModelStateHourlyEarningsId;
import com.model.EquipmentModel;
import com.model.EquipmentModelStateHourlyEarnings;
public interface EquipmentModelStateHourlyEarningsRepository extends JpaRepository<EquipmentModelStateHourlyEarnings, ModelStateHourlyEarningsId> {
	
}
