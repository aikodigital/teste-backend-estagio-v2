package com.app.project.util;

import com.app.project.requests.EquipmentModelPostRequest;

public class EquipmentModelPostRequestCreator {

    public static EquipmentModelPostRequest createEquipmentModelPostRequestBody() {
        return EquipmentModelPostRequest.builder()
                .name(EquipmentModelCreator.createEquipmentModelToBeSaved().getName())
                .build();
    }
}
