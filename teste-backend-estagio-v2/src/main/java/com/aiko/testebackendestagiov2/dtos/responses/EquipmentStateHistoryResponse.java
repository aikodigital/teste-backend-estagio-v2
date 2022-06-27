package com.aiko.testebackendestagiov2.dtos.responses;

import com.aiko.testebackendestagiov2.entities.EquipmentStateHistory;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Date;
import java.util.UUID;

@Data
public class EquipmentStateHistoryResponse {
    private Date date;
    @JsonProperty("equipment_id")
    private UUID equipmentId;
    @JsonProperty("equipment_state_id")
    private UUID equipmentStateId;

    public EquipmentStateHistoryResponse(EquipmentStateHistory equipmentStateHistory) {
        this.date = equipmentStateHistory.getDate();
        this.equipmentId = equipmentStateHistory.getEquipment().getId();
        this.equipmentStateId = equipmentStateHistory.getEquipmentState().getId();
    }
}
