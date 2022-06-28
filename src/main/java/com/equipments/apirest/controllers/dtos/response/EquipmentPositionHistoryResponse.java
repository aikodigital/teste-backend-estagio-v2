package com.equipments.apirest.controllers.dtos.response;

import com.equipments.apirest.models.EquipmentPositionHistory;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@AllArgsConstructor
@Getter
@Setter
public class EquipmentPositionHistoryResponse {

    private UUID equipmentId;

    private LocalDate date;

    private Float lat;

    private Float lon;

    public EquipmentPositionHistoryResponse(EquipmentPositionHistory equipmentPositionHistory) {
        this.equipmentId = equipmentPositionHistory.getEquipmentPositionHistoryId().getEquipment().getId();
        this.date = equipmentPositionHistory.getDate();
        this.lat = equipmentPositionHistory.getLat();
        this.lon = equipmentPositionHistory.getLon();
    }

}
