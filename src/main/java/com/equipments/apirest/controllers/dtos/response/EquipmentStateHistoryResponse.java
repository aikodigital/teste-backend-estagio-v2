package com.equipments.apirest.controllers.dtos.response;

import com.equipments.apirest.models.EquipmentStateHistory;
import com.equipments.apirest.models.EquipmentStateHistoryId;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@NoArgsConstructor
@Getter
@Setter
public class EquipmentStateHistoryResponse {

    private EquipmentStateHistoryId id;

    private LocalDate date;

    public EquipmentStateHistoryResponse(EquipmentStateHistory equipmentStateHistory) {
        this.id = equipmentStateHistory.getId();
        this.date = equipmentStateHistory.getDate();
    }
}
