package com.equipments.apirest.controllers.dtos.request;

import com.equipments.apirest.models.EquipmentModelStateHourlyEarnings;
import com.equipments.apirest.models.EquipmentModelStateHourlyEarningsId;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@NoArgsConstructor
@Getter
@Setter
public class EquipmentHourlyEarningsRequest {

    private Float value;
    private UUID equipmentModelId;
    private UUID equipmentStateId;

    public EquipmentModelStateHourlyEarnings toModel() {
        EquipmentModelStateHourlyEarnings earnings = new EquipmentModelStateHourlyEarnings();

        earnings.setValue(this.value);
        earnings.setId(new EquipmentModelStateHourlyEarningsId(this.equipmentModelId, this.equipmentStateId));

        return earnings;
    }

}
