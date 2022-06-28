package com.app.project.util.equipPositionHistory;

import com.app.project.requests.equipPositionHistory.EquipPositionHistoryPostRequest;
import com.app.project.util.equip.EquipCreator;

public class EquipPositionHistoryPostRequestCreator {
    public static EquipPositionHistoryPostRequest createEquipPositionHistoryPostRequestCreator() {
        return EquipPositionHistoryPostRequest.builder()
                .equipment(EquipCreator.createEquipmentValid().getId())
                .lat(-23.559050F)
                .lon(-46.640227F)
                .build();
    }
}
