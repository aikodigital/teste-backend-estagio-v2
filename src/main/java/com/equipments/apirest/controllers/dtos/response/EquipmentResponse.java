package com.equipments.apirest.controllers.dtos.response;

import com.equipments.apirest.models.Equipment;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@NoArgsConstructor
@Getter
@Setter
public class EquipmentResponse {

    private UUID id;

    private String name;

    private EquipmentModelResponse equipmentModel;

    public EquipmentResponse(Equipment equipment) {
        this.id = equipment.getId();
        this.name = equipment.getName();
        this.equipmentModel = new EquipmentModelResponse(equipment.getEquipmentModel());
    }

}
