package com.aiko.testebackendestagiov2.dtos.responses;

import com.aiko.testebackendestagiov2.entities.EquipmentPositionHistory;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.UUID;

@Data
public class EquipmentPositionHistoryResponse {
    private Float lat;
    private Float lon;
    @JsonProperty("equipment_id")
    private UUID equipmentId;

    public EquipmentPositionHistoryResponse(EquipmentPositionHistory equipmentPositionHistory) {
        this.lat = equipmentPositionHistory.getLat();
        this.lon = equipmentPositionHistory.getLon();
        this.equipmentId = equipmentPositionHistory.getEquipment().getId();
    }
}
