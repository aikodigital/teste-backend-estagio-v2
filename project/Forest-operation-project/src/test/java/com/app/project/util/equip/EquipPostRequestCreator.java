package com.app.project.util.equip;

import com.app.project.requests.equip.EquipPostRequest;
import org.mockito.ArgumentMatchers;

public class EquipPostRequestCreator {

    public static EquipPostRequest createEquipmentModelPostRequestBody() {
        return EquipPostRequest.builder()
                .name(ArgumentMatchers.anyString())
                .build();
    }
}
