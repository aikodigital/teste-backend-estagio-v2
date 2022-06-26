package com.app.project.util.equip;

import com.app.project.requests.equip.EquipPostRequest;
import com.app.project.requests.equip.EquipPutRequest;
import org.mockito.ArgumentMatchers;

public class EquipPutRequestCreator {
    public static EquipPutRequest createEquipmentPutRequestBody() {
        return EquipPutRequest.builder()
                .id(EquipCreator.createEquipmentModelValid().getId())
                .name(ArgumentMatchers.anyString())
                .model(EquipCreator.createEquipmentModelValid().getModel())
                .build();
    }
}
