package com.equipments.apirest.controllers.dtos.response;

import com.equipments.apirest.models.EquipmentState;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@NoArgsConstructor
@Getter
@Setter
public class EquipmentStateResponse {
    private UUID equipmentStateId;

    private String name;

    private String color;

    public EquipmentStateResponse(EquipmentState equipmentState) {
        this.equipmentStateId = equipmentState.getId();
        this.name = equipmentState.getName();
        this.color = equipmentState.getColor();
    }
}
