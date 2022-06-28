package com.equipments.apirest.controllers.dtos.request;

import com.equipments.apirest.models.EquipmentPositionHistory;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor
@Getter
public class EquipmentPositionHistoryRequest {

    private LocalDate date;
    private Float lat;
    private Float lon;

    public EquipmentPositionHistory toModel() {
        final var equipmentPosition = new EquipmentPositionHistory();
        equipmentPosition.setDate(this.date);
        equipmentPosition.setLat(this.lat);
        equipmentPosition.setLon(this.lon);
        return equipmentPosition;
    }
}
