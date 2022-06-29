package com.app.project.util.equipModel;

import com.app.project.requests.equipModel.EquipmentModelPostRequest;

public class EquipModelPostRequestCreator {

    public static EquipmentModelPostRequest createEquipmentModelPostRequestBody() {
        return EquipmentModelPostRequest.builder()
                .name(EquipModelCreator.createEquipmentModelToBeSaved().getName())
                .build();
    }
}
