package io.github.humbertoluiz.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import io.github.humbertoluiz.domain.entity.Equipment;
import io.github.humbertoluiz.dto.EquipmentDTO;

public interface EquipmentService {

	Equipment save( EquipmentDTO equipmentDTO );
	
	List<Equipment> getByFilter(Equipment filter);

	Optional<Equipment> getById(UUID equipmentId);

	void delete(UUID equipmentId);

	Optional<Equipment> update(UUID equipmentId, Equipment equipment);

}
