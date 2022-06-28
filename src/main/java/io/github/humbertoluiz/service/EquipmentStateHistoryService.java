package io.github.humbertoluiz.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import io.github.humbertoluiz.domain.entity.EquipmentStateHistory;
import io.github.humbertoluiz.dto.EquipmentStateHistoryDTO;

public interface EquipmentStateHistoryService {

	EquipmentStateHistory save( EquipmentStateHistoryDTO equipmentStateHistoryDTO );
	
	void update( UUID equipmentStateHistoryId );
	
	List<EquipmentStateHistory> getByFilter(EquipmentStateHistory filter);

	Optional<EquipmentStateHistory> getById(UUID equipmentStateHistoryId);

	void delete(UUID EquipmentModelStateHourlyEarningsId);
}
