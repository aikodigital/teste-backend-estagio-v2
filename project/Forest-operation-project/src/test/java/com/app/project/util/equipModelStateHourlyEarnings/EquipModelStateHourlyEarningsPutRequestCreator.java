package com.app.project.util.equipModelStateHourlyEarnings;

import com.app.project.requests.equipModelStateHourlyEarnings.EquipModelStateHourlyEarningsPutRequest;
import com.app.project.util.equipModel.EquipmentModelCreator;
import com.app.project.util.equipState.EquipStateCreator;

import java.math.BigDecimal;

public class EquipModelStateHourlyEarningsPutRequestCreator {
    public static EquipModelStateHourlyEarningsPutRequest createEquipModelStateHourlyEarningsPostRequestCreator() {
        return EquipModelStateHourlyEarningsPutRequest.builder()
                .id(EquipModelStateHourlyEarningsCreator.createEquipmentModelStateHourlyEarningsValid().getId())
                .equipmentModelId(EquipmentModelCreator.createEquipmentModelToBeSaved().getId())
                .equipmentStateId(EquipStateCreator.createEquipmentStateToBeSaved().getId())
                .value(BigDecimal.valueOf(50))
                .build();
    }
}
