package com.aiko.testebackendestagiov2.dtos.responses;

import com.aiko.testebackendestagiov2.entities.Equipment;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.UUID;

@Data
public class EquipmentResponse {
    private UUID id;
    private String name;
    @JsonProperty("equipment_model_id")
    private UUID equipmentModelId;

    public EquipmentResponse(Equipment equipment) {
        this.id = equipment.getId();
        this.name = equipment.getName();
        this.equipmentModelId = equipment.getEquipmentModel().getId();
    }
}
