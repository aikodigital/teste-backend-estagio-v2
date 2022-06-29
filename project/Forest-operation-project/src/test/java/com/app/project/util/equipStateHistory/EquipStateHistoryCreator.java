package com.app.project.util.equipStateHistory;

import com.app.project.domain.EquipmentStateHistory;
import com.app.project.util.equip.EquipCreator;
import com.app.project.util.equipState.EquipStateCreator;

import java.time.LocalDateTime;
import java.util.UUID;

public class EquipStateHistoryCreator {

    public static EquipmentStateHistory createEquipStateHistoryValid() {
        return EquipmentStateHistory.builder()
                .id(UUID.fromString("2c616b33-c9f1-4300-a97d-e429ec0c0825"))
                .equipment(EquipCreator.createEquipmentValid())
                .equipmentState(EquipStateCreator.createEquipmentStateValid())
                .date(LocalDateTime.of(2022, 06, 27, 2, 2))
                .build();
    }
}
