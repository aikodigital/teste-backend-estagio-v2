package com.app.project.util.equipPositionHistory;

import com.app.project.domain.EquipmentPositionHistory;
import com.app.project.util.equip.EquipCreator;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public class EquipPositionHistoryCreator {
    public static EquipmentPositionHistory createEquipPositionHistoryValid() {
        return EquipmentPositionHistory.builder()
                .id(UUID.fromString("2c616b33-c9f1-4300-a97d-e429ec0c0825"))
                .lat(BigDecimal.valueOf(-23.559050F))
                .lon(BigDecimal.valueOf(-46.640227F))
                .equipment(EquipCreator.createEquipmentValid())
                .date(LocalDateTime.of(2022, 06, 27, 2, 2))
                .build();
    }
}
