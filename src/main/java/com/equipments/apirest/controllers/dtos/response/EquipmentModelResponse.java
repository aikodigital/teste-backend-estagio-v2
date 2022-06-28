package com.equipments.apirest.controllers.dtos.response;

import com.equipments.apirest.models.EquipmentModel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@NoArgsConstructor
@Getter
@Setter
public class EquipmentModelResponse {

    private UUID id;

    private String name;

    public EquipmentModelResponse(EquipmentModel equipmentModel) {
        this.id = equipmentModel.getId();
        this.name = equipmentModel.getName();
    }


}
