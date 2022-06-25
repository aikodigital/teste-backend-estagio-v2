package com.app.project.util;

import com.app.project.requests.EquipmentModelPutRequest;

public class EquipmentModelPutRequestCreator {

    public static EquipmentModelPutRequest createEquipmentModelPutRequestBody() {
        return EquipmentModelPutRequest.builder()
                .id(EquipmentModelCreator.createEquipmentModelValid().getId())
                .name(EquipmentModelCreator.createEquipmentModelToBeSaved().getName())
                .build();
    }
}
