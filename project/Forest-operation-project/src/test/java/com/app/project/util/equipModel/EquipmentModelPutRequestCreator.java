package com.app.project.util.equipModel;

import com.app.project.requests.equipModel.EquipmentModelPutRequest;

public class EquipmentModelPutRequestCreator {

    public static EquipmentModelPutRequest createEquipmentModelPutRequestBody() {
        return EquipmentModelPutRequest.builder()
                .id(EquipmentModelCreator.createEquipmentModelValid().getId())
                .name(EquipmentModelCreator.createEquipmentModelToBeSaved().getName())
                .build();
    }
}
