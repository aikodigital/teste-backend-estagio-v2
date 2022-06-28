package io.github.humbertoluiz.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import io.github.humbertoluiz.domain.entity.EquipmentPositionHistory;
import io.github.humbertoluiz.dto.EquipmentPositionHistoryDTO;

public interface EquipmentPositionHystoryService {

	EquipmentPositionHistory save( EquipmentPositionHistoryDTO equipmentPositionHistoryDTO );
	
	void update( UUID equipmentPositionHistoryId );
	
	List<EquipmentPositionHistory> getByFilter(EquipmentPositionHistory filter);

	Optional<EquipmentPositionHistory> getById(UUID equipmentPositionHistoryId);

	void delete(UUID equipmentPositionHistoryId);
}
