package com.estagio.aiko.equipments.api.infrastructure.persistence.repository.equipment;

import java.util.UUID;

import com.estagio.aiko.equipments.api.domain.equipment.model.EquipmentModel;
import com.estagio.aiko.equipments.api.infrastructure.persistence.repository.shared.BaseRepository;

public interface EquipmentModelRepository extends BaseRepository<EquipmentModel, UUID> {

}
