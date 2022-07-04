package io.github.humbertoluiz.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import io.github.humbertoluiz.domain.entity.EquipmentState;
import io.github.humbertoluiz.dto.EquipmentStateDTO;

public interface EquipmentStateService {

	EquipmentState save( EquipmentStateDTO equipmentStateDTO );

	List<EquipmentState> getByFilter(EquipmentState filter);

	Optional<EquipmentState> getById(UUID equipmentStateId);

	void delete(UUID equipmentStateId);

	Optional<EquipmentState> update(UUID equipmentStateId, EquipmentState equipmentState);
	
}
