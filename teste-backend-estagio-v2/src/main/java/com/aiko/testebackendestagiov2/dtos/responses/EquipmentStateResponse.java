package com.aiko.testebackendestagiov2.dtos.responses;

import com.aiko.testebackendestagiov2.entities.EquipmentState;
import lombok.Data;

import java.util.UUID;

@Data
public class EquipmentStateResponse {
    private UUID id;
    private String name;
    private String color;

    public EquipmentStateResponse(EquipmentState equipmentState) {
        this.id = equipmentState.getId();
        this.name = equipmentState.getName();
        this.color = equipmentState.getColor();
    }
}
