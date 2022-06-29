package com.app.project.util.equipModelStateHourlyEarnings;

import com.app.project.domain.EquipmentModelStateHourlyEarnings;
import com.app.project.util.equipModel.EquipModelCreator;
import com.app.project.util.equipState.EquipStateCreator;

import java.math.BigDecimal;

public class EquipModelStateHourlyEarningsCreator {

    public static EquipmentModelStateHourlyEarnings createEquipmentModelStateHourlyEarningsValid() {
        return EquipmentModelStateHourlyEarnings.builder()
                .equipmentModel(EquipModelCreator.createEquipmentModelValid())
                .equipmentState(EquipStateCreator.createEquipmentStateValid())
                .value(BigDecimal.valueOf(100))
                .build();
    }
}
