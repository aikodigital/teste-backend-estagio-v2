package com.estagio.aiko.equipments.api.infrastructure.persistence.repository.equipment;

import java.util.UUID;

import com.estagio.aiko.equipments.api.domain.equipment.model.EquipmentState;
import com.estagio.aiko.equipments.api.infrastructure.persistence.repository.shared.BaseRepository;

public interface EquipmentStateRepository extends BaseRepository<EquipmentState, UUID> {

}
