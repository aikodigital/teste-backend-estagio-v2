package com.aiko.testebackendestagiov2.dtos.requests;

import lombok.Data;

import java.util.UUID;

@Data
public class EquipmentPositionHistoryRequest {
    private Float lat;
    private Float lon;
    private UUID equipmentId;
}
