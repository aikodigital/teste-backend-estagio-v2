package com.app.project.util.equipStateHistory;

import com.app.project.domain.Equipment;
import com.app.project.domain.EquipmentState;
import com.app.project.domain.EquipmentStateHistory;
import com.app.project.exceptions.NotFoundException;
import com.app.project.requests.equipStateHistory.EquipStateHistoryPostRequest;
import com.app.project.util.equip.EquipCreator;
import com.app.project.util.equipState.EquipStateCreator;

import java.time.LocalDateTime;

public class EquipStateHistoryPostRequestCreator {

    public static EquipStateHistoryPostRequest createEquipStateHistoryPostRequestCreator() {
        return EquipStateHistoryPostRequest.builder()
                .equipmentId(EquipCreator.createEquipmentValid().getId())
                .equipmentStateId(EquipStateCreator.createEquipmentStateValid().getId())
                .build();
    }

    public static EquipStateHistoryPostRequest createEquipStateHistoryPostRequestServiceCreator() throws NotFoundException {
        return toRelateEntitiesInfos(
                EquipStateHistoryPostRequestCreator.createEquipStateHistoryPostRequestCreator());
    }
    private static EquipStateHistoryPostRequest toRelateEntitiesInfos(EquipStateHistoryPostRequest postRequest) throws NotFoundException {
        Equipment equip = EquipCreator.createEquipmentValid();
        EquipmentState equipState = EquipStateCreator.createEquipmentStateValid();

        EquipStateHistoryPostRequest equipToSave = EquipStateHistoryPostRequest.builder()
                .equipmentId(equip.getId())
                .equipmentStateId(equipState.getId())
                .build();
        return equipToSave;
    }
}
