package com.aiko.testebackendestagiov2.dtos.requests;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.UUID;

@Data
public class EquipmentModelStateHourlyEarningsRequest {
    @NotNull(message = "Value may not be null")
    private Float value;
    @NotNull(message = "EquipmentModelId may not be null")
    private UUID equipmentModelId;
    @NotNull(message = "EquipmentStateId may not be null")
    private UUID equipmentStateId;
}
