package com.app.project.util.equipStateHistory;

import com.app.project.requests.equipStateHistory.EquipStateHistoryPutRequest;

import java.time.LocalDateTime;

public class EquipStateHistoryPutRequestCreator {
    public static EquipStateHistoryPutRequest createEquipStateHistoryPutRequestCreator() {
        return EquipStateHistoryPutRequest.builder()
                .id(EquipStateHistoryCreator.createEquipStateHistoryValid().getId())
                .equipment(EquipStateHistoryCreator.createEquipStateHistoryValid().getEquipment())
                .equipmentState(EquipStateHistoryCreator.createEquipStateHistoryValid().getEquipmentState())
                .date(LocalDateTime.of(2022, 06, 27, 2, 2))
                .build();
    }
}
