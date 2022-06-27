package com.app.project.util.equipState;

import com.app.project.requests.equipState.EquipStatePostRequest;

public class EquipStatePostRequestCreator {

    public static EquipStatePostRequest createEquipStatePostRequestBody() {
        return EquipStatePostRequest.builder()
                .name("Stopped")
                .color("Blue")
                .build();
    }
}
