package com.aiko.testebackendestagiov2.dtos.responses;

import com.aiko.testebackendestagiov2.entities.EquipmentModel;
import lombok.Data;

import java.util.UUID;

@Data
public class EquipmentModelResponse {
    private UUID id;
    private String name;

    public EquipmentModelResponse(EquipmentModel equipmentModel) {
        this.id = equipmentModel.getId();
        this.name = equipmentModel.getName();
    }
}
