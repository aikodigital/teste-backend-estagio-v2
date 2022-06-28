package com.app.project.util.equipPositionHistory;

import com.app.project.requests.equipPositionHistory.EquipPositionHistoryPutRequest;
import com.app.project.util.equip.EquipCreator;

import java.math.BigDecimal;

public class EquipPositionHistoryPutRequestCreator {
    public static EquipPositionHistoryPutRequest createEquipPositionHistoryPutRequestCreator() {
        return EquipPositionHistoryPutRequest.builder()
                .id(EquipPositionHistoryCreator.createEquipPositionHistoryValid().getId())
                .equipment(EquipCreator.createEquipmentValid().getId())
                .lat(BigDecimal.valueOf(-23.559050))
                .lon(BigDecimal.valueOf(-46.640227))
                .build();
    }
}
