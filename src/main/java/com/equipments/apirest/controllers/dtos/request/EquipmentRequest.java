package com.equipments.apirest.controllers.dtos.request;

import com.equipments.apirest.models.Equipment;
import com.equipments.apirest.models.EquipmentModel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@NoArgsConstructor
@Getter
public class EquipmentRequest {

    private String name;

    private UUID equipmentModelId;

    public Equipment toModel() {
        final var equipmentModel = new EquipmentModel();
        equipmentModel.setId(this.equipmentModelId);

        final var equipment = new Equipment();
        equipment.setName(this.name);
        equipment.setEquipmentModel(equipmentModel);
        return equipment;


    }


}
