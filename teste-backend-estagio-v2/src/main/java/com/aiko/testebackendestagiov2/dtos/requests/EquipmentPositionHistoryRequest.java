package com.aiko.testebackendestagiov2.dtos.requests;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.UUID;

@Data
public class EquipmentPositionHistoryRequest {
    @NotNull(message = "Lat may not be null")
    private Float lat;
    @NotNull(message = "Lon may not be null")
    private Float lon;
    @NotNull(message = "EquipmentId may not be null")
    private UUID equipmentId;
}
