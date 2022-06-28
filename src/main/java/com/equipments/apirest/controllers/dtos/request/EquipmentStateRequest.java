package com.equipments.apirest.controllers.dtos.request;

import com.equipments.apirest.models.EquipmentState;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class EquipmentStateRequest {

    private String name;

    private String color;

    public EquipmentState toModel() {
        final var equipmentState = new EquipmentState();
        equipmentState.setName(this.name);
        equipmentState.setColor(this.color);
        return equipmentState;
    }
}
