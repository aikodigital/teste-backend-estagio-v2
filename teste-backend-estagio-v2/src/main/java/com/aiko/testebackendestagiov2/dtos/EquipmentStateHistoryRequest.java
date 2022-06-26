package com.aiko.testebackendestagiov2.dtos;

import lombok.Data;

import java.util.UUID;

@Data
public class EquipmentStateHistoryRequest {
    private UUID equipmentId;
    private UUID equipmentStateId;
}
