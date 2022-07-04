package io.github.humbertoluiz.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import io.github.humbertoluiz.domain.entity.EquipmentModel;
import io.github.humbertoluiz.dto.EquipmentModelDTO;

public interface EquipmentModelService {

	EquipmentModel save( EquipmentModelDTO equipmentModelDTO );

	List<EquipmentModel> getByFilter(EquipmentModel filter);

	Optional<EquipmentModel> getById(UUID equipmentModelId);

	void delete(UUID equipmentModelId);

	Optional<EquipmentModel> update(UUID equipmentModelId, EquipmentModel equipmentModel);

}
