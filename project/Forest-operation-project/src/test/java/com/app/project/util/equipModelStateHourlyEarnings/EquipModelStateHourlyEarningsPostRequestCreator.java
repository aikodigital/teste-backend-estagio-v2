package com.app.project.util.equipModelStateHourlyEarnings;

import com.app.project.requests.EquipModelStateHourlyEarnings.EquipModelStateHourlyEarningsPostRequest;

public class EquipModelStateHourlyEarningsPostRequestCreator {

    public static EquipModelStateHourlyEarningsPostRequest createEquipmentModelStateHourlyEarningsPostRequestCreator() {
        return EquipModelStateHourlyEarningsPostRequest.builder()
                .equipmentModelId(EquipModelStateHourlyEarningsCreator.createEquipmentModelStateHourlyEarningsValid().getId())
                .equipmentStateId(EquipModelStateHourlyEarningsCreator.createEquipmentModelStateHourlyEarningsValid().getId())
                .value(EquipModelStateHourlyEarningsCreator.createEquipmentModelStateHourlyEarningsValid().getValue())
                .build();
    }
}
