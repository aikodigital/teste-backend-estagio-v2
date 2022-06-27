package com.aiko.testebackendestagiov2.dtos.requests;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.UUID;

@Data
public class EquipmentStateHistoryRequest {
    @NotNull(message = "EquipmentId may not be blank")
    private UUID equipmentId;
    @NotNull(message = "EquipmentStateId may not be blank")
    private UUID equipmentStateId;
}
