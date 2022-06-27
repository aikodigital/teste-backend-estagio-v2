package com.app.project.util.equipState;

import com.app.project.requests.equipState.EquipStatePutRequest;

public class EquipStatePutRequestCreator {

    public static EquipStatePutRequest createEquipStatePutRequestBody() {
        return EquipStatePutRequest.builder()
                .id(1L)
                .name("maintenance")
                .color("Blue")
                .build();
    }
}
