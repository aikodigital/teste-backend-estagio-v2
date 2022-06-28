package com.equipments.apirest.controllers.dtos.response;

import com.equipments.apirest.models.EquipmentModelStateHourlyEarnings;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class EquipmentHourlyEarningsResponse {

    private EquipmentModelResponse equipmentModel;

    private EquipmentStateResponse equipmentState;

    private Float value;

    public EquipmentHourlyEarningsResponse(EquipmentModelStateHourlyEarnings earnings) {
        this.equipmentModel = new EquipmentModelResponse(earnings.getId().getEquipmentModel());
        this.equipmentState = new EquipmentStateResponse(earnings.getId().getEquipmentState());
        this.value = earnings.getValue();
    }

}
