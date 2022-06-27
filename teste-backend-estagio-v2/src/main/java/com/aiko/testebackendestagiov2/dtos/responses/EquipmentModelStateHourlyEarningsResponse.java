package com.aiko.testebackendestagiov2.dtos.responses;

import com.aiko.testebackendestagiov2.entities.EquipmentModelStateHourlyEarnings;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.UUID;

@Data
public class EquipmentModelStateHourlyEarningsResponse {
    private UUID id;
    private Float value;

    @JsonProperty( "equipment_model_id")
    private UUID equipmentModelId;

    @JsonProperty( "equipment_state_id")
    private UUID equipmentStateID;

    public EquipmentModelStateHourlyEarningsResponse(EquipmentModelStateHourlyEarnings equipmentModelStateHourlyEarnings) {
        this.id = equipmentModelStateHourlyEarnings.getId();
        this.value = equipmentModelStateHourlyEarnings.getValue();
        this.equipmentModelId = equipmentModelStateHourlyEarnings.getEquipmentModel().getId();
        this.equipmentStateID = equipmentModelStateHourlyEarnings.getEquipmentState().getId();
    }
}
