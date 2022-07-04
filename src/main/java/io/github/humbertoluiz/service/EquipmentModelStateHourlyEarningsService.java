package io.github.humbertoluiz.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import io.github.humbertoluiz.domain.entity.EquipmentModelStateHourlyEarnings;
import io.github.humbertoluiz.dto.EquipmentModelStateHourlyEarningsDTO;

public interface EquipmentModelStateHourlyEarningsService {

	EquipmentModelStateHourlyEarnings save( EquipmentModelStateHourlyEarningsDTO equipmentModelStateHourlyEarningsDTO );
	
	List<EquipmentModelStateHourlyEarnings> getByFilter(EquipmentModelStateHourlyEarnings filter);

	Optional<EquipmentModelStateHourlyEarnings> getById(UUID equipmentModelStateHourlyEarningsId);

	void delete(UUID equipmentModelStateHourlyEarningsId);

	Optional<EquipmentModelStateHourlyEarnings> update(UUID equipmentModelStateHourlyEarningsId,
			EquipmentModelStateHourlyEarnings equipmentModelStateHourlyEarnings);


}
