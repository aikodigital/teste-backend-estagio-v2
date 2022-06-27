package com.aiko.testebackendestagiov2.dtos.responses;

import lombok.Data;

import java.util.UUID;

@Data
public class CurrentEquipmentPositionResponse {
    private UUID equipmentId;
    private String equipmentName;
    private Float lat;
    private Float lon;
}
