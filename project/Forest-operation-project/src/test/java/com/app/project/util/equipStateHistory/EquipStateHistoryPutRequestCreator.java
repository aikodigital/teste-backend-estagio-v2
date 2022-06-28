package com.app.project.util.equipStateHistory;

import com.app.project.domain.Equipment;
import com.app.project.domain.EquipmentState;
import com.app.project.exceptions.NotFoundException;
import com.app.project.requests.equipStateHistory.EquipStateHistoryPostRequest;
import com.app.project.requests.equipStateHistory.EquipStateHistoryPutRequest;
import com.app.project.util.equip.EquipCreator;
import com.app.project.util.equipModel.EquipmentModelCreator;
import com.app.project.util.equipState.EquipStateCreator;

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
