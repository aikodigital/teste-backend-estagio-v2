package com.aiko.testebackendestagiov2.dtos.requests;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Data
public class EquipmentRequest {
    @NotBlank(message = "Name may not be blank")
    private String name;
    @NotNull(message = "EquipmentModelId may not be blank")
    private UUID equipmentModelId;
}
