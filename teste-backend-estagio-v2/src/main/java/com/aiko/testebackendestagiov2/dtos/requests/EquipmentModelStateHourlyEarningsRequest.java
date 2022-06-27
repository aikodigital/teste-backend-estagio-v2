package com.aiko.testebackendestagiov2.dtos.requests;

import lombok.Data;

import java.util.UUID;

@Data
public class EquipmentModelStateHourlyEarningsRequest {
    private Float value;
    private UUID equipmentModelId;
    private UUID equipmentStateId;
}
