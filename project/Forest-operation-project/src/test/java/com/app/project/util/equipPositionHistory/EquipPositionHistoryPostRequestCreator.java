package com.app.project.util.equipPositionHistory;

import com.app.project.requests.equipPositionHistory.EquipPositionHistoryPostRequest;
import com.app.project.util.equip.EquipCreator;

import java.math.BigDecimal;

public class EquipPositionHistoryPostRequestCreator {
    public static EquipPositionHistoryPostRequest createEquipPositionHistoryPostRequestCreator() {
        return EquipPositionHistoryPostRequest.builder()
                .equipment(EquipCreator.createEquipmentValid().getId())
                .lat(BigDecimal.valueOf(-23.559050))
                .lon(BigDecimal.valueOf(-46.640227))
                .build();
    }
}
