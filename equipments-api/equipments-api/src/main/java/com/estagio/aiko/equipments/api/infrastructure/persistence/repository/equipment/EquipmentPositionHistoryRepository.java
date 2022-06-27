package com.estagio.aiko.equipments.api.infrastructure.persistence.repository.equipment;

import com.estagio.aiko.equipments.api.domain.equipment.model.EquipmentPositionHistory;
import com.estagio.aiko.equipments.api.domain.equipment.model.EquipmentPositionHistoryId;
import com.estagio.aiko.equipments.api.infrastructure.persistence.repository.shared.BaseRepository;

public interface EquipmentPositionHistoryRepository
		extends BaseRepository<EquipmentPositionHistory, EquipmentPositionHistoryId> {

}
