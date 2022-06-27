package com.estagio.aiko.equipments.api.infrastructure.persistence.repository.equipment;

import com.estagio.aiko.equipments.api.domain.equipment.model.EquipmentStateHistory;
import com.estagio.aiko.equipments.api.domain.equipment.model.EquipmentStateHistoryId;
import com.estagio.aiko.equipments.api.infrastructure.persistence.repository.shared.BaseRepository;

public interface EquipmentStateHistoryRepository
		extends BaseRepository<EquipmentStateHistory, EquipmentStateHistoryId> {

}
