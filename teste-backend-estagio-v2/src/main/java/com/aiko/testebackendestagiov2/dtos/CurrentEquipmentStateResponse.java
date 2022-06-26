package com.aiko.testebackendestagiov2.dtos;

import lombok.Data;

import java.util.UUID;

@Data
public class CurrentEquipmentStateResponse {
    private UUID equipmentId;
    private String equipmentName;
    private String stateName;
    private String stateColor;
}
