package com.aiko.testebackendestagiov2.dtos.responses;

import com.aiko.testebackendestagiov2.entities.EquipmentPositionHistory;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Date;
import java.util.UUID;

@Data
public class EquipmentPositionHistoryResponse {
    private UUID id;
    private Float lat;
    private Float lon;
    private Date date;
    @JsonProperty("equipment_id")
    private UUID equipmentId;

    public EquipmentPositionHistoryResponse(EquipmentPositionHistory equipmentPositionHistory) {
        this.id = equipmentPositionHistory.getId();
        this.lat = equipmentPositionHistory.getLat();
        this.lon = equipmentPositionHistory.getLon();
        this.date = equipmentPositionHistory.getDate();
        this.equipmentId = equipmentPositionHistory.getEquipment().getId();
    }
}
