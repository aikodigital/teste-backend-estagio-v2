package com.app.project.util.equip;

import com.app.project.requests.equip.EquipPutRequest;
import org.mockito.ArgumentMatchers;

public class EquipPutRequestCreator {
    public static EquipPutRequest createEquipmentPutRequestBody() {
        return EquipPutRequest.builder()
                .id(EquipCreator.createEquipmentValid().getId())
                .name(ArgumentMatchers.anyString())
                .model(EquipCreator.createEquipmentValid().getModel())
                .build();
    }
}
