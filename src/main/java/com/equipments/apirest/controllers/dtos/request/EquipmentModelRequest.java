package com.equipments.apirest.controllers.dtos.request;

import com.equipments.apirest.models.EquipmentModel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class EquipmentModelRequest {

    private String name;


    public EquipmentModel toModel() {
        final var equipmentModel = new EquipmentModel();
        equipmentModel.setName(this.name);
        return equipmentModel;
    }


}
