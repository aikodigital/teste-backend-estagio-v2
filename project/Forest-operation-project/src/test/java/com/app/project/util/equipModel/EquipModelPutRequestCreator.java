package com.app.project.util.equipModel;

import com.app.project.requests.equipModel.EquipmentModelPutRequest;

public class EquipModelPutRequestCreator {

    public static EquipmentModelPutRequest createEquipmentModelPutRequestBody() {
        return EquipmentModelPutRequest.builder()
                .id(EquipModelCreator.createEquipmentModelValid().getId())
                .name(EquipModelCreator.createEquipmentModelToBeSaved().getName())
                .build();
    }
}