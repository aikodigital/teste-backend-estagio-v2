package com.app.project.requests.equipPositionHistory;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EquipPositionHistoryPutRequest {

    @NotNull
    private UUID id;

    @NotBlank
    private UUID equipment;

    @NotBlank
    private BigDecimal lat;

    @NotBlank
    private BigDecimal lon;
}
