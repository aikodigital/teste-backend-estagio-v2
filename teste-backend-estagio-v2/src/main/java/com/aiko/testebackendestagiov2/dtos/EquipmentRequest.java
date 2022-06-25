package com.aiko.testebackendestagiov2.dtos;

import lombok.Data;

import java.util.UUID;

@Data
public class EquipmentRequest {
    private String name;
    private UUID equipmentModelId;
}
