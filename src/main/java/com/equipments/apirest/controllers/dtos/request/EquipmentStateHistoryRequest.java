package com.equipments.apirest.controllers.dtos.request;

import com.equipments.apirest.models.EquipmentStateHistory;
import com.equipments.apirest.models.EquipmentStateHistoryId;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@NoArgsConstructor
@Getter
public class EquipmentStateHistoryRequest {

    private LocalDate date;

    private EquipmentStateHistoryId id;

    private UUID equipmentId;

    public EquipmentStateHistory toModel() {
        final var equipmentStateHistory = new EquipmentStateHistory();
        equipmentStateHistory.setDate(this.date);
        return equipmentStateHistory;
    }
}
