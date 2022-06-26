package com.app.project.util.equipModel;

import com.app.project.requests.equipModel.EquipmentModelPostRequest;

public class EquipmentModelPostRequestCreator {

    public static EquipmentModelPostRequest createEquipmentModelPostRequestBody() {
        return EquipmentModelPostRequest.builder()
                .name(EquipmentModelCreator.createEquipmentModelToBeSaved().getName())
                .build();
    }
}
