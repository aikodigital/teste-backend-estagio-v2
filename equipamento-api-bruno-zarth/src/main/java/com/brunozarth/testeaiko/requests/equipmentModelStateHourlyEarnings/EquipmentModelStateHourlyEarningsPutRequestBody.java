package com.brunozarth.testeaiko.requests.equipmentModelStateHourlyEarnings;

import com.brunozarth.testeaiko.model.EquipmentModelStateHourlyEarningsId;
import lombok.Data;

import java.util.UUID;

@Data
public class EquipmentModelStateHourlyEarningsPutRequestBody {

    private EquipmentModelStateHourlyEarningsId id;

    private UUID equipmentModelId;

    private UUID equipmentStateId;
    
    private float value;
}
